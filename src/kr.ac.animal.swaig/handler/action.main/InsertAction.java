package handler.action.main;

import common.controller.Action;
import handler.dao.main.AnimalDao;
import handler.dto.PostAnimalReq;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InsertAction implements Action {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
//        System.out.println("dd");

        PostAnimalReq postAnimalReq=new PostAnimalReq();
        request.setCharacterEncoding("UTF-8");
        postAnimalReq.setAnimalName(request.getParameter("animalName"));
        postAnimalReq.setAnimalBirth(request.getParameter("animalBirth"));
        postAnimalReq.setAnimalType(request.getParameter("animalType"));
        postAnimalReq.setAnimalKind(request.getParameter("animalKind"));
        postAnimalReq.setMaster(request.getParameter("master"));
        postAnimalReq.setPhoneNumber(request.getParameter("phoneNumber"));

        AnimalDao.insertAnimal(postAnimalReq);
        System.out.println("Animal Add Success");
        return "RequestDispatcher:jsp/main/insert.jsp";
    }
}
