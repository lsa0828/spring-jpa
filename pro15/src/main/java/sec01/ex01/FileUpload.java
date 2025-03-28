package sec01.ex01;

import java.io.File;
import java.nio.file.Paths;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import jakarta.servlet.http.Part;

@MultipartConfig(
	    fileSizeThreshold = 1024 * 1024 * 2, // 2MB
	    maxFileSize = 1024 * 1024 * 10,      // 10MB
	    maxRequestSize = 1024 * 1024 * 50    // 50MB
	)
@WebServlet("/upload.do")
public class FileUpload extends HttpServlet {
	private static final String UPLOAD_DIR = "uploads";
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}
	
	protected void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		// String uploadPath = getServletContext().getRealPath("") + File.separator + UPLOAD_DIR;
        String uploadPath = "C:\\Java" + File.separator + UPLOAD_DIR;
		File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) uploadDir.mkdir();

        for (Part part : request.getParts()) {
        	if (part.getSubmittedFileName()!=null) {
        		String fileName = Paths.get(part.getSubmittedFileName()).getFileName().toString();
                part.write(uploadPath + File.separator + fileName);
                System.out.println("업로드:" + fileName);
        	} else {
        		String fieldName = part.getName();
        		System.out.println(fieldName + ":" + request.getParameter(fieldName));
        	}
        }

        response.getWriter().println("File uploaded successfully!");
	}

}
