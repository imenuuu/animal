package handler.action.main;

import common.controller.Action;
import handler.dao.main.AnimalDao;
import handler.dto.GetAnimalRes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

public class AnimalAction implements Action {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String name=request.getParameter("name");
        ArrayList<GetAnimalRes> getAnimalRes=new ArrayList<>();

        if (name!=null) {
            getAnimalRes=AnimalDao.searchAnimalList(name);
        }

        else if(name==null){
            getAnimalRes=AnimalDao.getAnimalList();
        }

        request.setAttribute("list", getAnimalRes);
        return "RequestDispatcher:jsp/main/main.jsp";
    }
}
