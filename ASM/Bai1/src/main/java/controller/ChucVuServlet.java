package controller;

import Repository.ChucVuRepository;
import Repository.SanPhamRepository;
import domain_model.ChucVu;
import domain_model.MauSac;
import domain_model.SanPham;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.apache.commons.beanutils.BeanUtils;
import view_model.QLChucVu;


import java.io.IOException;

@WebServlet({
        "/chuc-vu/index",    // GET
        "/chuc-vu/create",   // GET
        "/chuc-vu/edit",     // GET
        "/chuc-vu/delete",   // GET
        "/chuc-vu/store",    // POST
        "/chuc-vu/update",   // POST
})
public class ChucVuServlet extends HttpServlet {
    private ChucVuRepository cvRepo;
    public ChucVuServlet(){
        this.cvRepo = new ChucVuRepository();

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
//        request.getRequestDispatcher("/view/chuc_vu/create.jsp")
//                .forward(request, response);
        request.setAttribute("view", "/view/chuc_vu/create.jsp");
        request.getRequestDispatcher("/view/layout.jsp")
                .forward(request, response);
    }
    protected void index(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        request.setAttribute("danhSachCV",this.cvRepo.findAll());

        request.setAttribute("view", "/view/chuc_vu/index.jsp");
        request.getRequestDispatcher("/view/layout.jsp")
                .forward(request, response);
    }
    protected void edit(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        Integer id = Integer.parseInt(request.getParameter("id"));
        ChucVu cv = this.cvRepo.findByMa(id);
        request.setAttribute("cv", cv);
//        request.getRequestDispatcher("/view/chuc_vu/edit.jsp")
//                .forward(request, response);
        request.setAttribute("view", "/view/chuc_vu/edit.jsp");
        request.getRequestDispatcher("/view/layout.jsp")
                .forward(request, response);
    }
    protected void delete(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        Integer id = Integer.parseInt(request.getParameter("id"));
        ChucVu cv = this.cvRepo.findByMa(id);
        this.cvRepo.delete(cv);
        response.sendRedirect("/Bai1_war_exploded/chuc-vu/index");
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
            response.sendRedirect("/Bai1_war_exploded/chuc-vu/index");
        }

    }
    protected void store(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        try {
            ChucVu cv = new ChucVu();
            BeanUtils.populate(cv, request.getParameterMap());
            this.cvRepo.insert(cv);
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("/Bai1_war_exploded/chuc-vu/index");
    }
    protected void update(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        try {
            Integer id = Integer.parseInt(request.getParameter("id"));
            ChucVu cv = this.cvRepo.findByMa(id);
            BeanUtils.populate(cv, request.getParameterMap());
            this.cvRepo.update(cv);
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("/Bai1_war_exploded/chuc-vu/index");
    }
}
