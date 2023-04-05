package controller;

import Repository.NhanVienRepository;
import domain_model.NhanVien;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet({
        "/login",
})
public class LoginServlet extends HttpServlet {
    private NhanVienRepository nvRepo = new NhanVienRepository();
    @Override
    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
//        request.setAttribute("view", "/view/login.jsp");
//        request.getRequestDispatcher("/view/layout.jsp")
//                .forward(request, response);
                request.getRequestDispatcher("/view/login.jsp")
                .forward(request, response);
    }

    @Override
    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        String matKhau = request.getParameter("matKhau");
        NhanVien nv = this.nvRepo.login(ma, matKhau);
        HttpSession session = request.getSession();
        if (nv == null) {
            session.setAttribute("errorMessage", "Sai tài khoản hoặc mật khẩu");
            response.sendRedirect("/Bai1_war_exploded/login");
        } else {
            session.setAttribute("nv", nv);
            response.sendRedirect("/Bai1_war_exploded/khach-hang/index");
        }
    }
}
