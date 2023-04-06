package controller;


import Repository.SanPhamRepository;

import domain_model.SanPham;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.apache.commons.beanutils.BeanUtils;


import javax.swing.*;
import java.io.IOException;


@WebServlet({
        "/san-pham/index",    // GET
        "/san-pham/create",   // GET
        "/san-pham/edit",     // GET
        "/san-pham/delete",   // GET
        "/san-pham/store",    // POST
        "/san-pham/update",   // POST
})
public class SanPhamServlet extends HttpServlet {
    private SanPhamRepository spRepo;
    public SanPhamServlet(){

            this.spRepo = new SanPhamRepository();
    }

    @Override
    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("create")) {
            this.create(request, response);
        } else if (uri.contains("edit")) {
            this.edit(request, response);
        } else if (uri.contains("delete")) {
            this.delete(request, response);
        } else {
            this.index(request, response);
        }
           }
    protected void create(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
//        request.getRequestDispatcher("/view/san_pham/create.jsp")
//                .forward(request, response);
        request.setAttribute("view", "/view/san_pham/create.jsp");
        request.getRequestDispatcher("/view/layout.jsp")
                .forward(request, response);
    }
    protected void index(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        request.setAttribute("danhSachSP",this.spRepo.findAll());
//        request.getRequestDispatcher("/view/san_pham/index.jsp")
//                .forward(request, response);
        request.setAttribute("view", "/view/san_pham/index.jsp");
        request.getRequestDispatcher("/view/layout.jsp")
                .forward(request, response);
    }
    protected void edit(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        SanPham sp = this.spRepo.findByMa(ma);
        request.setAttribute("sp", sp);
//        request.getRequestDispatcher("/view/san_pham/edit.jsp")
//                .forward(request, response);
        request.setAttribute("view", "/view/san_pham/edit.jsp");
        request.getRequestDispatcher("/view/layout.jsp")
                .forward(request, response);
    }
    protected void delete(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        SanPham sp = this.spRepo.findByMa(ma);
        this.spRepo.delete(sp);
        response.sendRedirect("/Bai1_war_exploded/san-pham/index");
    }
    @Override
    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("store")) {
            this.store(request, response);
        } else if (uri.contains("update")) {
            this.update(request, response);
        } else {
            response.sendRedirect("/Bai1_war_exploded/khach-hang/index");
        }

    }
    protected void store(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        try {
            SanPham sp = new SanPham();
            BeanUtils.populate(sp, request.getParameterMap());
            this.spRepo.insert(sp);
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("/Bai1_war_exploded/san-pham/index");
    }
    protected void update(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        try {
            String ma = request.getParameter("ma");
            SanPham sp = this.spRepo.findByMa(ma);
            BeanUtils.populate(sp, request.getParameterMap());
            this.spRepo.update(sp);
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("/Bai1_war_exploded/san-pham/index");
    }

}
