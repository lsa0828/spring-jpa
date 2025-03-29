package sec01.ex02;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/download.do")
public class FileDownload extends HttpServlet {
	private static final String DOWNLOAD_DIR = "uploads";
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}
	
	protected void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String fileName = (String) request.getParameter("fileName"); // 다운로드할 파일명 받기
        if (fileName == null || fileName.isEmpty()) {
            response.getWriter().println("파일명을 입력하세요.");
            return;
        }
        System.out.println("fileName=" + fileName);

        // String filePath = getServletContext().getRealPath("") + File.separator + DOWNLOAD_DIR + File.separator + fileName;
        String filePath = "C:\\Java" + File.separator + DOWNLOAD_DIR + File.separator + fileName;
        File file = new File(filePath);
        
        if (!file.exists()) {
            response.getWriter().println("파일이 존재하지 않습니다.");
            return;
        }

        // 응답 헤더 설정
        response.setContentType("application/octet-stream");
        response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");
        response.setContentLength((int) file.length());

        // 파일을 스트림으로 전송
        try (FileInputStream fis = new FileInputStream(file);
             OutputStream out = response.getOutputStream()) {
            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = fis.read(buffer)) != -1) {
                out.write(buffer, 0, bytesRead);
            }
        }
	}

}
