/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2020-01-10 10:39:26 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.view.admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class top_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("   <nav class=\"navbar navbar-expand navbar-dark bg-dark static-top\">\r\n");
      out.write("\r\n");
      out.write("      <a class=\"navbar-brand mr-1\" href=\"index.html\">CMS系统后台</a>\r\n");
      out.write("\r\n");
      out.write("      <button class=\"btn btn-link btn-sm text-white order-1 order-sm-0\" id=\"sidebarToggle\">\r\n");
      out.write("        <i class=\"fas fa-bars\"></i>\r\n");
      out.write("      </button>\r\n");
      out.write("\r\n");
      out.write("      <!-- Navbar Search -->\r\n");
      out.write("      <form class=\"d-none d-md-inline-block form-inline ml-auto mr-0 mr-md-3 my-2 my-md-0\">\r\n");
      out.write("        <div class=\"input-group\">\r\n");
      out.write("          <input type=\"text\" class=\"form-control\" placeholder=\"Search for...\" aria-label=\"Search\" aria-describedby=\"basic-addon2\">\r\n");
      out.write("          <div class=\"input-group-append\">\r\n");
      out.write("            <button class=\"btn btn-primary\" type=\"button\">\r\n");
      out.write("              <i class=\"fas fa-search\"></i>\r\n");
      out.write("            </button>\r\n");
      out.write("          </div>\r\n");
      out.write("        </div>\r\n");
      out.write("      </form>\r\n");
      out.write("\r\n");
      out.write("      <!-- Navbar -->\r\n");
      out.write("      <ul class=\"navbar-nav ml-auto ml-md-0\">\r\n");
      out.write("        <li class=\"nav-item dropdown no-arrow mx-1\">\r\n");
      out.write("          <a class=\"nav-link\" href=\"#\" id=\"messagesDropdown\" role=\"button\"  aria-haspopup=\"true\" aria-expanded=\"false\">\r\n");
      out.write("            <i class=\"fas fa-envelope fa-fw\"></i>\r\n");
      out.write("            <span class=\"badge badge-danger\">7</span>\r\n");
      out.write("          </a>\r\n");
      out.write("        </li>\r\n");
      out.write("        <li class=\"nav-item dropdown no-arrow\">\r\n");
      out.write("          <a class=\"nav-link dropdown-toggle\" href=\"#\" id=\"userDropdown\" role=\"button\" data-toggle=\"dropdown\" aria-haspopup=\"true\" aria-expanded=\"false\">\r\n");
      out.write("            <i class=\"fas fa-user-circle fa-fw\"></i>\r\n");
      out.write("          </a>\r\n");
      out.write("          <div class=\"dropdown-menu dropdown-menu-right\" aria-labelledby=\"userDropdown\">\r\n");
      out.write("            <a class=\"dropdown-item\" href=\"#\">返回网站</a>\r\n");
      out.write("            <a class=\"dropdown-item\" href=\"#\">修改密码</a>\r\n");
      out.write("            <div class=\"dropdown-divider\"></div>\r\n");
      out.write("            <a class=\"dropdown-item\" href=\"/logout\">退出</a>\r\n");
      out.write("          </div>\r\n");
      out.write("        </li>\r\n");
      out.write("      </ul>\r\n");
      out.write("\r\n");
      out.write("    </nav>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
