<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<th width="60%" scope="row">
  <img src="image/mision.png" width="500" height="418"> 
</th>

<td width="40%">
  <div id="wowslider-container1">
      <div class="ws_images">
        <c:if test="${not empty userMsg }">
 			<h1>${msgTitle }</h1>
			<span>
				<c:out value="${userMsg }"/>		
			</span>
		</c:if>
      </div>
  </div>
</td>
