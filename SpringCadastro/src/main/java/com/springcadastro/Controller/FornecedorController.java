package com.springcadastro.Controller;

import com.springcadastro.LoginSecurity;
import com.springcadastro.Model.*;
import com.springcadastro.Pattern.FornecedorPattern;
import com.springcadastro.Service.FornecedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/fornecedor")
public class FornecedorController {
    @Autowired
    private FornecedorService fornecedorService;

    @RequestMapping("")
    public String getForm(){
        if(!LoginSecurity.getInstance().isLogado())
            return LoginSecurity.REDIRECT;

        return "formularios/formulario-fornecedor";
    }

    @RequestMapping("/lista")
    public ModelAndView getFormAdd(){
        ModelAndView view = new ModelAndView("listas/lista-fornecedor");
        view.addObject("listaFornecedor", this.fornecedorService.getListaFornecedor());
        return view;
    }

    @PostMapping("/cadastro")
    public String save(Fornecedor fornecedor){
        if(!LoginSecurity.getInstance().isLogado())
            return LoginSecurity.REDIRECT;

        if(new FornecedorPattern(fornecedor).verifica()){
            fornecedorService.save(fornecedor);
            return "avisos/aviso-sucesso";
        }

        return "avisos/aviso-falha";
    }

    @PostMapping("/deleta")
    public String delete(String id){
        if(!LoginSecurity.getInstance().isLogado())
            return LoginSecurity.REDIRECT;
        fornecedorService.delete(id);
        return "avisos/aviso-sucesso";
    }

    @PostMapping("/edita")
    public String edit(Fornecedor fornecedor){
        if(!LoginSecurity.getInstance().isLogado())
            return LoginSecurity.REDIRECT;

        if(new FornecedorPattern(fornecedor).verifica()){
            fornecedorService.save(fornecedor);
            return "avisos/aviso-sucesso";
        }

        return "avisos/aviso-falha";
    }

    @PostMapping("/form-edita")
    public ModelAndView getFormEdit(String id){
        ModelAndView view = new ModelAndView("formularios/formulario-alter-fornecedor.html");
        view.addObject("fornecedor", this.fornecedorService.getFornecedor(id));
        return view;
    }
}
