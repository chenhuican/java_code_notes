package servlet;

import entity.Users;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "RegServlet")
public class RegServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Users u= new Users();
        String username;
        String mypassword;
        String gender;
        String introduce;
        String isAccept;
        Date birthday;
        String[] favorites;

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");

        try {
            username = request.getParameter("username");
            mypassword =request.getParameter("mypassword");
            gender = request.getParameter("gender");
            introduce = request.getParameter("introduce");
            birthday = sdf.parse(request.getParameter("birthday"));
            isAccept = request.getParameter("isAccept");
            //获取多个复选框的值
            favorites = request.getParameterValues("favorite");

            u.setUsername(username);
            u.setGender(gender);
            u.setBirthday(birthday);
            u.setMypassword(mypassword);
            u.setInstruduce(introduce);
            u.setFavorites(favorites);
            u.setAccept(isAccept.equals("true")?true:false);
            //把注册成功的用户保存到Session中
            request.getSession().setAttribute("regUser", u);

            //实现跳转
            request.getRequestDispatcher("../usrinfo.jsp").forward(request,response);


        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
