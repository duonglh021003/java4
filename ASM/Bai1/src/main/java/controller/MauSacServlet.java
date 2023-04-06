package controller;


import Repository.MauSacRepository;
import domain_model.MauSac;
import
jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.apache.commons.beanutils.BeanUtils;



import java.io.IOException;
@WebServlet({
        "/mau-sac/index",    // GET
        "/mau-sac/create",   // GET
        "/mau-sac/edit",     // GET
        "/mau-sac/delete",   // GET
        "/mau-sac/store",    // POST
        "/mau-sac/update",   // POST
})
public class MauSacServlet extends HttpServlet {
    private MauSacRepository msRepo;
    public MauSacServlet(){
        this.msRepo = new MauSacRepository();

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
//        request.getRequestDispatcher("/view/mau_sac/create.jsp")
//                .forward(request, response);
        request.setAttribute("view", "/view/mau_sac/create.jsp");
        request.getRequestDispatcher("/view/layout.jsp")
                .forward(request, response);
    }
    protected void index(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        request.setAttribute("danhSachMS",this.msRepo.findAll());
//        request.getRequestDispatcher("/view/mau_sac/index.jsp")
//                .forward(request, response);
        request.setAttribute("view", "/view/mau_sac/index.jsp");
        request.getRequestDispatcher("/view/layout.jsp")
                .forward(request, response);
    }
    protected void edit(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        MauSac ms = this.msRepo.findByMa(ma);
        request.setAttribute("ms", ms);
//        String ma = request.getParameter("ma");
//        QLMauSac kh = this.spRepo.findByMa(ma);
//        request.setAttribute("kh", kh);
        request.setAttribute("view", "/view/mau_sac/edit.jsp");
        request.getRequestDispatcher("/view/layout.jsp")
                .forward(request, response);
    }
    protected void delete(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
//        String ma = request.getParameter("ma");
//        QLMauSac sp = this.spRepo.findByMa(ma);
//        this.spRepo.delete(sp);
        String ma = request.getParameter("ma");
        MauSac ms = this.msRepo.findByMa(ma);
        this.msRepo.delete(ms);
        response.sendRedirect("/Bai1_war_exploded/mau-sac/index");
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
            response.sendRedirect("/Bai1_war_exploded/mau-sac/index");
        }

    }
    protected void store(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        try {
            MauSac ms = new MauSac();
            BeanUtils.populate(ms, request.getParameterMap());
            this.msRepo.insert(ms);
        } catch (Exception e) {
            e.printStackTrace();
        }

        response.sendRedirect("/Bai1_war_exploded/mau-sac/index");
    }
    protected void update(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        try {
            String ma = request.getParameter("ma");
            MauSac ms = this.msRepo.findByMa(ma);
            BeanUtils.populate(ms, request.getParameterMap());
            this.msRepo.update(ms);
        } catch (Exception e) {
            e.printStackTrace();
        }

        response.sendRedirect("/Bai1_war_exploded/mau-sac/index");
    }
}
