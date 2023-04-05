package controller;

import Repository.KhachHangRepository;
import domain_model.KhachHang;
import domain_model.SanPham;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.apache.commons.beanutils.BeanUtils;

import java.io.IOException;

@WebServlet({
        "/khach-hang/index",    // GET
        "/khach-hang/create",   // GET
        "/khach-hang/edit",     // GET
        "/khach-hang/delete",   // GET
        "/khach-hang/store",    // POST
        "/khach-hang/update",   // POST
})
public class KhachHangServlet extends HttpServlet {
    private KhachHangRepository khRepo;

    public KhachHangServlet()
    {
        this.khRepo = new KhachHangRepository();
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
        KhachHang domainModelKH = this.khRepo.findByMa(id);
        request.setAttribute("kh", domainModelKH);
        request.getRequestDispatcher("/view/khach_hang/edit.jsp")
                .forward(request, response);
    }

    protected void delete(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        Integer id = Integer.parseInt(request.getParameter("id"));
        KhachHang domainModelKH = this.khRepo.findByMa(id);
        this.khRepo.delete(domainModelKH);
        response.sendRedirect("/Bai1_war_exploded/khach-hang/index");
    }

    protected void index(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        request.setAttribute("danhSachKH", this.khRepo.findAll());
        request.setAttribute("view", "/view/khach_hang/index.jsp");
        request.getRequestDispatcher("/view/layout.jsp")
                .forward(request, response);
    }

    protected void create(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        request.getRequestDispatcher("/view/khach_hang/create.jsp")
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
            response.sendRedirect("/Bai1_war_exploded/khach-hang/index");
        }
    }

    protected void store(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        try {
            KhachHang domainModelKH = new KhachHang();
            BeanUtils.populate(domainModelKH, request.getParameterMap());
            this.khRepo.insert(domainModelKH);
        } catch (Exception e) {
            e.printStackTrace();
        }

        response.sendRedirect("/Bai1_war_exploded/khach-hang/index");
    }

    protected void update(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        try {
            Integer id = Integer.parseInt(request.getParameter("id"));
            KhachHang domainModelKH = this.khRepo.findByMa(id);
            BeanUtils.populate(domainModelKH, request.getParameterMap());
            this.khRepo.update(domainModelKH);
        } catch (Exception e) {
            e.printStackTrace();
        }

        response.sendRedirect("/Bai1_war_exploded/khach-hang/index");
    }
}
