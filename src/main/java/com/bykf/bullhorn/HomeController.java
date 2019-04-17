package com.bykf.bullhorn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
public class HomeController {
    @Autowired
    MessageRepository MessageRepository;
    @RequestMapping("/")
    public String listMessages(Model model){
        model.addAttribute("Messages",MessageRepository.findAll());
        return "list";
    }
    @GetMapping("/add")
    public String MessageForm(Model model){
        model.addAttribute("Message",new Message());
        return "messageform";
    }

    @PostMapping("/process")
    public String processForm(@Valid Message message,
                              BindingResult result){
        if(result.hasErrors()){
            return "messageform";
        }
        MessageRepository.save(message);
        return "redirect:/";
    }

    @RequestMapping("/detail/{id}")
    public String showCourse(@PathVariable("id") long id, Model model)
    {
        model.addAttribute("message", MessageRepository.findById(id).get());
        return "message";
    }

    @RequestMapping("/update/{id}")
    public String updateMessage(@PathVariable("id") long id,
                               Model model){
        model.addAttribute("message", MessageRepository.findById(id).get());
        return"messageform";
    }
    @RequestMapping("/delete/{id}")
    public String delMessage(@PathVariable("id") long id) {
        MessageRepository.deleteById(id);
        return "redirect:/";
    }
}

