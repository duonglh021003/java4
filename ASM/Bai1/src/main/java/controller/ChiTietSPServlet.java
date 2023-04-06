package controller;

import Repository.*;
import domain_model.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.apache.commons.beanutils.BeanUtils;


import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

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
//        Integer id = Integer.parseInt(request.getParameter("id"));
//        ChiTietSp ctsp = this.chiTietSPRepo.findByMa(id);
//        request.setAttribute("ctsp", ctsp);
//
//        request.setAttribute("danhSachSP",this.spRepo.findAll());
//        request.setAttribute("danhSachNsx",this.nsxRepo.findAll());
//        request.setAttribute("danhSachD",this.nsxRepo.findAll());
//        String ma = request.getParameter("ma");
//        NhanVien nv = this.nvRepo.findByMa(ma);
//        request.setAttribute("nv", nv);
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

//    protected void store(
//            HttpServletRequest request,
//            HttpServletResponse response
//    ) throws ServletException, IOException {
//        try {
//                ChiTietSp ctsp = new ChiTietSp();
//                BeanUtils.populate(ctsp, request.getParameterMap());
//                this.chiTietSPRepo.insert(ctsp);
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        response.sendRedirect("/Bai1_war_exploded/chi-tiet-sp/index");
//
//    }
protected void store(
        HttpServletRequest request,
        HttpServletResponse response
) throws ServletException, IOException {

    ChiTietSp domainModelKH = new ChiTietSp();
    String maSP = request.getParameter("sp");
    String maNSX = request.getParameter("nsx");
    String maMS = request.getParameter("ms");
    String maDongSP = request.getParameter("dongsp");
    domainModelKH.setSp(spRepo.findByMa(maSP));
    domainModelKH.setNsx(nsxRepo.findByMa(maNSX));
    domainModelKH.setMs(msRepo.findByMa(maMS));
    domainModelKH.setDongsp(dongSPRepo.findByMa(maDongSP));
    Map<String, String[] > parMap = new HashMap<>(request.getParameterMap());
    parMap.remove("sp");
    parMap.remove("nsx");
    parMap.remove("ms");
    parMap.remove("dongsp");
    try {
        BeanUtils.populate(domainModelKH, parMap);
        this.chiTietSPRepo.insert(domainModelKH);
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
