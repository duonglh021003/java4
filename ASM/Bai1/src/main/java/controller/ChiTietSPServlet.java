package controller;

import Repository.*;
import domain_model.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.apache.commons.beanutils.BeanUtils;


import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

@WebServlet({
        "/chi-tiet-sp/index",    // GET
        "/chi-tiet-sp/create",   // GET
        "/chi-tiet-sp/edit",     // GET
        "/chi-tiet-sp/delete",   // GET
        "/chi-tiet-sp/store",    // POST
        "/chi-tiet-sp/update",   // POST
})
public class ChiTietSPServlet extends HttpServlet {
    private ChiTietSPRepository chiTietSPRepo;

    private SanPhamRepository spRepo;
    private NsxRepository nsxRepo;
    private MauSacRepository msRepo;
    private DongSPRepository dongSPRepo;

    public ChiTietSPServlet()
    {
        this.chiTietSPRepo = new ChiTietSPRepository();
        this.spRepo = new SanPhamRepository();
        this.nsxRepo = new NsxRepository();
        this.msRepo = new MauSacRepository();
        this.dongSPRepo = new DongSPRepository();
    }

    @Override
    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
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

    protected void edit(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        Integer id = Integer.parseInt(request.getParameter("id"));
        ChiTietSp ctsp = this.chiTietSPRepo.findByMa(id);
        request.setAttribute("ctsp", ctsp);

        SanPham sp = this.spRepo.findByMa(id);
        request.setAttribute("sp", sp);

        Nsx nsx = this.nsxRepo.findByMa(id);
        request.setAttribute("nsx", nsx);

        MauSac ms = this.msRepo.findByMa(id);
        request.setAttribute("ms", ms);

        DongSp dongsp = this.dongSPRepo.findByMa(id);
        request.setAttribute("dongsp", dongsp);

        request.setAttribute("view", "/view/chi_tiet_sp/edit.jsp");
        request.getRequestDispatcher("/view/layout.jsp")
                .forward(request, response);
    }

    protected void delete(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        Integer id = Integer.parseInt(request.getParameter("id"));
        ChiTietSp ctsp = this.chiTietSPRepo.findByMa(id);
        this.chiTietSPRepo.delete(ctsp);
        response.sendRedirect("/Bai1_war_exploded/chi-tiet-sp/index");
    }

    protected void index(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
         request.setAttribute("danhSachchiTietSP", this.chiTietSPRepo.findAll());
        request.setAttribute("view", "/view/chi_tiet_sp/index.jsp");
        request.getRequestDispatcher("/view/layout.jsp")
                .forward(request, response);
    }

    protected void create(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        request.setAttribute("danhSachSP",this.spRepo.findAll());
        request.setAttribute("danhSachNsx",this.nsxRepo.findAll());
        request.setAttribute("danhSachMS",this.msRepo.findAll());
        request.setAttribute("danhSachDongSP",this.dongSPRepo.findAll());

        request.setAttribute("view", "/view/chi_tiet_sp/create.jsp");
        request.getRequestDispatcher("/view/layout.jsp")
                .forward(request, response);
    }

    @Override
    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("store")) {
            this.store(request, response);
        } else if (uri.contains("update")) {
            this.update(request, response);
        } else {
            response.sendRedirect("/Bai1_war_exploded/chi-tiet-sp/index");
        }
    }

    protected void store(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        try {
                ChiTietSp ctsp = new ChiTietSp();
                BeanUtils.populate(ctsp, request.getParameterMap());
                this.chiTietSPRepo.insert(ctsp);

        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("/Bai1_war_exploded/chi-tiet-sp/index");

    }

    protected void update(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        try {
            Integer id = Integer.parseInt(request.getParameter("id"));
            ChiTietSp ctsp = this.chiTietSPRepo.findByMa(id);
            BeanUtils.populate(ctsp, request.getParameterMap());
            this.chiTietSPRepo.update(ctsp);
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("/Bai1_war_exploded/chi-tiet-sp/index");
    }

}
