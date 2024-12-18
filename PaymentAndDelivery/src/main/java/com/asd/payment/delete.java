package com.asd.payment;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "delete", urlPatterns = "/delete")
public class delete extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");//通用编码，utf-8
        req.setCharacterEncoding("utf-8");
        int id = Integer.parseInt(req.getParameter("id"));
        HttpSession session = req.getSession();
        ArrayList<Food> cart = (ArrayList<Food>) session.getAttribute("cart");
        ArrayList<Food> cart_new = new ArrayList<Food>();
        for(Food food:cart) {
            if(food.getId()==id){
                System.out.println("yes,i am");
            }else{
                cart_new.add(food);
            }
        }
        session.removeAttribute("cart");
        session.setAttribute("cart",cart_new);
        resp.sendRedirect("/crud");
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);//数据转手给get方法
    }
}

