package controller;

import Repository.NsxRepository;
import domain_model.MauSac;
import domain_model.Nsx;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.apache.commons.beanutils.BeanUtils;



import java.io.IOException;
import java.util.ArrayList;

@WebServlet({
        "/Nsx/index",    // GET
        "/Nsx/create",   // GET
        "/Nsx/edit",     // GET
        "/Nsx/delete",   // GET
        "/Nsx/store",    // POST
        "/Nsx/update",   // POST
})
public class NsxServlet extends HttpServlet {
    private NsxRepository nsxRepo;
    public NsxServlet(){

        this.nsxRepo = new NsxRepository();

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
//        request.getRequestDispatcher("/view/Nsx/create.jsp")
//                .forward(request, response);
        request.setAttribute("view", "/view/Nsx/create.jsp");
        request.getRequestDispatcher("/view/layout.jsp")
                .forward(request, response);
    }
    protected void index(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        request.setAttribute("danhSachNsx",this.nsxRepo.findAll());
//        request.getRequestDispatcher("/view/mau_sac/index.jsp")
//                .forward(request, response);
        request.setAttribute("view", "/view/Nsx/index.jsp");
        request.getRequestDispatcher("/view/layout.jsp")
                .forward(request, response);

    }
    protected void edit(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        Nsx nsx = this.nsxRepo.findByMa(ma);
        request.setAttribute("nsx", nsx);
        request.setAttribute("view", "/view/Nsx/edit.jsp");
        request.getRequestDispatcher("/view/layout.jsp")
                .forward(request, response);
    }
    protected void delete(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        Nsx nsx = this.nsxRepo.findByMa(ma);
        this.nsxRepo.delete(nsx);
        response.sendRedirect("/Bai1_war_exploded/Nsx/index");
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
            response.sendRedirect("/Bai1_war_exploded/Nsx/index");
        }

    }
    protected void store(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        try {
            Nsx nsx = new Nsx();
            BeanUtils.populate(nsx, request.getParameterMap());
            this.nsxRepo.insert(nsx);
        } catch (Exception e) {
            e.printStackTrace();
        }

        response.sendRedirect("/Bai1_war_exploded/Nsx/index");
    }
    protected void update(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        try {
            String ma = request.getParameter("ma");
            Nsx nsx = this.nsxRepo.findByMa(ma);
            BeanUtils.populate(nsx, request.getParameterMap());
            this.nsxRepo.update(nsx);
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("/Bai1_war_exploded/Nsx/index");
    }
}
