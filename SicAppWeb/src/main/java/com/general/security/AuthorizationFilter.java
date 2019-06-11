package com.general.security;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author emoreno
 */

import com.general.entity.Sic1usuario;
import com.general.service.LoginServiceImpl;
import com.general.util.security.EncryptUtils;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/*
    We implement the standard filter class by overriding the destroy and doFilter methods. 
    In the doFilter method we will redirect user to login page if he tries to access other page without logging in.
*/

@WebFilter(filterName = "AuthFilter", urlPatterns = { "*.xhtml" })
public class AuthorizationFilter implements Filter {

	public AuthorizationFilter() {
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		try {

			HttpServletRequest reqt = (HttpServletRequest) request;
			HttpServletResponse resp = (HttpServletResponse) response;			
                        
                        /******************************************************************/
                        /****** Cuando se trata de ingresar al 
                         * sistema de manera externa enviando parametros en la url*********/
                        System.out.println("Paramentro1:" + reqt.getParameter("evento"));
                        System.out.println("Paramentro2:" + reqt.getParameter("usuario"));
                        
                        //El nombre del usuario se recibe de manera encriptada
                        HttpSession ses = null;
                        String strUsuarioExterno = reqt.getParameter("usuario");
                        if(strUsuarioExterno != null){
                            
                            //Se desencripta el usuario.
                            strUsuarioExterno = strUsuarioExterno.replace(" ", "+");
                            String strUsuarioDesencriptado = EncryptUtils.decrypt(strUsuarioExterno);
                            
                            System.out.println("strUsuarioDesencriptado:" + strUsuarioDesencriptado);
                            
                            LoginServiceImpl loginServiceImpl = new LoginServiceImpl();
                            Sic1usuario user = loginServiceImpl.validarPersonaXUsuario(strUsuarioDesencriptado);
                            
                            if(user != null){                                
                                ses = reqt.getSession(false);
                                ses.setAttribute("user", user);
                            }else
                                ses = reqt.getSession(false);
                            
                        }else
                            ses = reqt.getSession(false);
                        
			String reqURI = reqt.getRequestURI();
                        
			if (reqURI.indexOf("/login.xhtml") >= 0
					|| (ses != null && ses.getAttribute("user") != null)
					|| reqURI.indexOf("/public/") >= 0
					|| reqURI.contains("javax.faces.resource"))
				chain.doFilter(request, response);
			else
				resp.sendRedirect(reqt.getContextPath() + "/faces/login.xhtml");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public void destroy() {

	}
}