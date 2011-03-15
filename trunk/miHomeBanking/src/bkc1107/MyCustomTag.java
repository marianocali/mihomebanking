package bkc1107;


import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;

public class MyCustomTag implements Tag 
{
  PageContext pageContext;

  public void setParent(Tag t) {
  }

  public void setPageContext(PageContext p) {
    pageContext = p;
  }

  public void release() {
  }

  public Tag getParent() {
    return null;
  }
  public int doStartTag() {
    try 
    {
      JspWriter out = pageContext.getOut();
      out.println("Hello from the tag handler.");
    }
    catch(Exception e) {
    }
    return EVAL_BODY_INCLUDE;
  }

  public int doEndTag() throws JspException {
    return EVAL_PAGE;
  }
}
