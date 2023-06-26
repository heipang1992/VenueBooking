/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/TagHandler.java to edit this template
 */
package ict.tag;

import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 *
 * @author USER
 */
public class venue extends SimpleTagSupport {

    private String v1;
    private String v2;
    private String v3;
    private String v4;
    private String v5;

    /**
     * Called by the container to invoke this tag. The implementation of this
     * method is provided by the tag library developer, and handles all tag
     * processing, body iteration, etc.
     */
    @Override
    public void doTag() throws JspException {
        JspWriter out = getJspContext().getOut();
        
        try {
            out.println("<table border=\"1\" > ");     
             out.println("<tr><th>Venue</th><th>Image</th><th>Type</th><th>Capacity</th><th>Location</th><th>Description</th><th>Person-in-charge</th><th>Booking Fee</th></tr>");
             out.println("<tr><td>Sha Tin</td><td><img src='"+v1+"' width='250' height='200'/></td><td>Meeting Room</td><td>250 peoples</td><td>21 Yuen Wo Road</td><td>I LOVE VTC</td><td>Will Kwok</td><td>$400per hour</td></tr>");
         out.println("<tr><td>Tsing Yi</td><td><img src='"+v2+"' width='250' height='200'/></td><td>Dining Room</td><td>200 peoples</td><td>35 Tsing Yi City Road</td><td>Dining, Annual Dinner</td><td>Kenneth Chan</td><td>$700per hour</td></tr>");
         out.println("<tr><td>Lee Wai Lee</td><td><img src='"+v3+"' width='250' height='200'/></td><td>Classroom</td><td>50 peoples</td><td>47 Lee Wai Lee Road</td><td>Tutorial, Lecture</td><td>Alan Po</td><td>$150per hour</td></tr>");
         out.println("<tr><td>Tuen Mun</td><td><img src='"+v4+"' width='250' height='200'/></td><td>Hall</td><td>100 peoples</td><td>1 Tuen Kung Suck Chat Road</td><td>Marriage provided lawyer</td><td>Sky Wong</td><td>$400per hour</td></tr>");
         out.println("<tr><td>Chai Wan</td><td><img src='"+v5+"' width='250' height='200'/></td><td>Dining Room</td><td>300 peoples</td><td>21 Chai Wan Kwok Street</td><td>Dining, Music Concert, Festival</td><td>Dennis Poon</td><td>$1000per hour</td></tr>");
         out.println("</table>");
        } catch (Exception e) {

        }
    }

    public void setV1(String v1) {
        this.v1 = v1;
    }

    public void setV2(String v2) {
        this.v2 = v2;
    }

    public void setV3(String v3) {
        this.v3 = v3;
    }

    public void setV4(String v4) {
        this.v4 = v4;
    }

    public void setV5(String v5) {
        this.v5 = v5;
    }
    
}
