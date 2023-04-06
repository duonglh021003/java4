package controller;

import Repository.DongSPRepository;
import Repository.SanPhamRepository;
import domain_model.DongSp;
import domain_model.MauSac;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.apache.commons.beanutils.BeanUtils;
import view_model.QLDongSP;
import view_model.QLMauSac;
import view_model.QLSanPham;


import java.io.IOException;
import java.util.ArrayList;

@WebServlet({
        "/DongSP/index",    // GET
        "/DongSP/create",   // GET
        "/DongSP/edit",     // GET
        "/DongSP/delete",   // GET
        "/DongSP/store",    // POST
        "/DongSP/update",   // POST
})
public class DongSPServlet extends HttpServlet {
    private DongSPRepository dongSPRepo;
    public DongSPServlet(){

        this.dongSPRepo = new DongSPRepository();

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
//        request.getRequestDispatcher("/view/DongSP/create.jsp")
//                .forward(request, response);
        request.setAttribute("view", "/view/DongSP/create.jsp");
        request.getRequestDispatcher("/view/layout.jsp")
                .forward(request, response);
    }
    protected void index(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        request.setAttribute("danhSachDongSP",this.dongSPRepo.findAll());
//        request.getRequestDispatcher("/view/DongSP/index.jsp")
//                .forward(request, response);
        request.setAttribute("view", "/view/DongSP/index.jsp");
        request.getRequestDispatcher("/view/layout.jsp")
                .forward(request, response);
    }

    protected void edit(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        DongSp kh = this.dongSPRepo.findByMa(ma);
        request.setAttribute("dongsp", kh);
//        request.getRequestDispatcher("/view/DongSP/edit.jsp")
//                .forward(request, response);
        request.setAttribute("view", "/view/DongSP/edit.jsp");
        request.getRequestDispatcher("/view/layout.jsp")
                .forward(request, response);
    }
    protected void delete(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        DongSp sp = this.dongSPRepo.findByMa(ma);
        this.dongSPRepo.delete(sp);
        response.sendRedirect("/Bai1_war_exploded/DongSP/index");
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
            response.sendRedirect("/Bai1_war_exploded/DongSP/index");
        }

    }
    protected void store(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        try {
            DongSp ms = new DongSp();
            BeanUtils.populate(ms, request.getParameterMap());
            this.dongSPRepo.insert(ms);
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("/Bai1_war_exploded/DongSP/index");
    }
    protected void update(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        try {
            String ma = request.getParameter("ma");
            DongSp ms = this.dongSPRepo.findByMa(ma);
            BeanUtils.populate(ms, request.getParameterMap());
            this.dongSPRepo.update(ms);
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("/Bai1_war_exploded/DongSP/index");
    }
}
