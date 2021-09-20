package loanapp.controller;

import loanapp.dao.LoanDao;
import loanapp.model.Loan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class LoanController {

    @Autowired
    LoanDao loanDao;

    @RequestMapping("/add")
    public String showNewClientPage(Model model) {
        Loan loan = new Loan();
        model.addAttribute("loan", loan);
        return "new_client";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveClient(@ModelAttribute("loan") Loan loan) {
        loanDao.save(loan);
        System.out.println(loan);
        return "redirect:/";
    }

    @RequestMapping("/")
    public String home(Model model) {

        Loan loan = new Loan();
        model.addAttribute("loan", loan);

/*        for (Voting vt : votingDao.findAll()) {
            System.out.print(vt.toString());
        }

        model.addAttribute("listOfQuestions", votingDao.findAll());*/

        return "index";
    }

    @RequestMapping("/results")
    public String results(Model model) {

        for (Loan ln : loanDao.findAll()) {
            System.out.print(ln.toString());
        }

        model.addAttribute("listOfVotes", loanDao.findAll());
        return "results";
    }

}
