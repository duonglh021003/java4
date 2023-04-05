package controller;

import Repository.ChucVuRepository;
import Repository.CuaHangRepository;
import Repository.KhachHangRepository;
import Repository.NhanVienRepository;
import domain_model.NhanVien;
import domain_model.SanPham;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.apache.commons.beanutils.BeanUtils;
import view_model.QLKhachHang;
import view_model.QLNhanVien;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

@WebServlet({
        "/nhan-vien/index",    // GET
        "/nhan-vien/create",   // GET
        "/nhan-vien/edit",     // GET
        "/nhan-vien/delete",   // GET
        "/nhan-vien/store",    // POST
        "/nhan-vien/update",   // POST
})
public class NhanVienServlet extends HttpServlet {
    private NhanVienRepository nvRepo;
    private CuaHangRepository chRepo;
    private ChucVuRepository cvRepo;
    public NhanVienServlet()
    {

        this.nvRepo = new NhanVienRepository();
        this.chRepo = new CuaHangRepository();
        this.cvRepo = new ChucVuRepository();

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
        NhanVien nv = this.nvRepo.findByMa(id);
        request.setAttribute("nv", nv);
//        request.getRequestDispatcher("/view/nhan_vien/edit.jsp")
//                .forward(request, response);
        request.setAttribute("view", "/view/nhan_vien/edit.jsp");
        request.getRequestDispatcher("/view/layout.jsp")
                .forward(request, response);
    }

    protected void delete(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        Integer id = Integer.parseInt(request.getParameter("id"));
        NhanVien nv = this.nvRepo.findByMa(id);
        this.nvRepo.delete(nv);
        response.sendRedirect("/Bai1_war_exploded/nhan-vien/index");
    }

    protected void index(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        request.setAttribute("danhSachNV", this.nvRepo.findAll());

        request.setAttribute("view", "/view/nhan_vien/index.jsp");
        request.getRequestDispatcher("/view/layout.jsp")
                .forward(request, response);
    }

    protected void create(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        request.setAttribute("danhSachCH",this.chRepo.findAll());
        request.setAttribute("danhSachCV",this.cvRepo.findAll());

        request.setAttribute("view", "/view/nhan_vien/create.jsp");
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
            response.sendRedirect("/Bai1_war_exploded/nhan-vien/index");
        }
    }

    protected void store(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        try {
            NhanVien nv = new NhanVien();
            BeanUtils.populate(nv, request.getParameterMap());
            this.nvRepo.insert(nv);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        response.sendRedirect("/Bai1_war_exploded/nhan-vien/index");

    }

    protected void update(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        try {
            Integer id = Integer.parseInt(request.getParameter("id"));
            NhanVien nv = this.nvRepo.findByMa(id);
            BeanUtils.populate(nv, request.getParameterMap());
            this.nvRepo.update(nv);
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("/Bai1_war_exploded/nhan-vien/index");
    }
}
