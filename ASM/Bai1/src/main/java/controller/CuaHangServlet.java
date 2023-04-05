package controller;

import Repository.CuaHangRepository;
import domain_model.CuaHang;
import domain_model.SanPham;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.apache.commons.beanutils.BeanUtils;
import view_model.QLCuaHang;


import java.io.IOException;

@WebServlet({
        "/cua-hang/index",    // GET
        "/cua-hang/create",   // GET
        "/cua-hang/edit",     // GET
        "/cua-hang/delete",   // GET
        "/cua-hang/store",    // POST
        "/cua-hang/update",   // POST
})
public class CuaHangServlet extends HttpServlet {
    private CuaHangRepository chRepo;

    public CuaHangServlet()
    {
        this.chRepo = new CuaHangRepository();
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
        CuaHang ch = this.chRepo.findByMa(id);
        request.setAttribute("ch", ch);
//        request.getRequestDispatcher("/view/cua_hang/edit.jsp")
//                .forward(request, response);
        request.setAttribute("view", "/view/cua_hang/edit.jsp");
        request.getRequestDispatcher("/view/layout.jsp")
                .forward(request, response);
    }

    protected void delete(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        Integer id = Integer.parseInt(request.getParameter("id"));
        CuaHang ch = this.chRepo.findByMa(id);
        this.chRepo.delete(ch);
        response.sendRedirect("/Bai1_war_exploded/cua-hang/index");
    }

    protected void index(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        request.setAttribute("danhSachCH", this.chRepo.findAll());
//        request.getRequestDispatcher("/view/cua_hang/index.jsp")
//                .forward(request, response);
        request.setAttribute("view", "/view/cua_hang/index.jsp");
        request.getRequestDispatcher("/view/layout.jsp")
                .forward(request, response);
    }

    protected void create(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
//        request.getRequestDispatcher("/view/cua_hang/create.jsp")
//                .forward(request, response);
        request.setAttribute("view", "/view/cua_hang/create.jsp");
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
            response.sendRedirect("/Bai1_war_exploded/cua-hang/index");
        }
    }

    protected void store(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        try {
            CuaHang ch = new CuaHang();
            BeanUtils.populate(ch, request.getParameterMap());
            this.chRepo.insert(ch);
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("/Bai1_war_exploded/cua-hang/index");

    }

    protected void update(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        try {
            Integer id = Integer.parseInt(request.getParameter("id"));
            CuaHang ch = this.chRepo.findByMa(id);
            BeanUtils.populate(ch, request.getParameterMap());
            this.chRepo.update(ch);
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("/Bai1_war_exploded/cua-hang/index");
    }
}
