package bkc1110;

import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;

public class DoublerTag implements Tag {
  private int number;
  public void setNumber(int number) {
    this.number = number;
  }
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
    try {
      JspWriter out = pageContext.getOut();
      out.println("Double of " + number + " is " + (2 * number));
    }
    catch(Exception e) {
    }
    return EVAL_BODY_INCLUDE;
  }

  public int doEndTag() throws JspException {
    return EVAL_PAGE;
  }
}
