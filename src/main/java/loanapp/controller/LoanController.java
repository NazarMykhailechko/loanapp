package loanapp.controller;

import loanapp.dao.LoanDao;
import loanapp.model.Loan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class LoanController {

    @Autowired
    LoanDao loanDao;

    @RequestMapping("/addloan")
    public String showNewClientPage(Model model) {
        Loan loan = new Loan();
        model.addAttribute("loan", loan);
        return "addloan";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveClient(@ModelAttribute("loan") Loan loan) {
        loanDao.save(loan);
        System.out.println(loan);
        return "redirect:/";
    }

    @RequestMapping("/")
    public String home(Model model) {

/*        Loan loan = new Loan();
        model.addAttribute("loan", loan);
        */

        for (Loan ln : loanDao.findAll()) {
            System.out.print(ln.toString());
        }

        model.addAttribute("listOfLoans", loanDao.findAll());

        return "index";
    }

    @RequestMapping("/results")
    public String results(Model model) {

        for (Loan ln : loanDao.findAll()) {
            System.out.print(ln.toString());
        }

        model.addAttribute("listOfLoans", loanDao.findAll());
        return "index";
    }

/*    @RequestMapping(value = "/deleteClient/{id}")
    public String deleteClient(@PathVariable(name = "id") int id) {
        loanDao.deleteById(id);
        return "redirect:/";
    }*/

    @RequestMapping(value = "/updateloan/{id}")
    public ModelAndView updateClient(@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView("updateloan");
        Loan loan = loanDao.findById(id).get();
        mav.addObject("loan", loan);
        return mav;
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String saveUpdateClient(@RequestParam("id") int id,
                                   @RequestParam("edrpou") String edrpou,
                                   @RequestParam("name") String name,
                                   @RequestParam("sum") String sum,
                                   @RequestParam("documents") String documents) {
        //String userlogin = System.getenv("username");
        Loan loan = loanDao.findById(id).get();
        loan.setEdrpou(edrpou);
        loan.setName(name);
        loan.setSum(sum);
        loan.setDocuments(documents);
        loanDao.save(loan);
        return "redirect:/";
    }

}
