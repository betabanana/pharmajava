     <div class="table" id="table">
 <%@ page  import="dao.*" %>
             <table><%--<c:out value="${a.getStatus_comm()}"/> --%> 
                      <thead>
                              <tr>
                                <td>Id Client</td>
                                <td> quantite commande</td>
                                <td>Prix de commande </td>
                               <td>Date commande</td>
                               <td> fichier de ordannance  </td>
                               <td COLSPAN=2> --- </td>
                               </tr>
                      </thead>                       
                      <tbody>
                                
                       <c:if test="${com!=null}">
                        <c:forEach items="${com}" var="a">
                         <tr> 
                                   <td >
                                   <c:out value="${a.getId_util() }"/>
                                   </td>
                                   <td>
                                   <c:set value="${a.getId_comm()}" var="varName"  scope="page"/>
                                      <%
                                        int varName = (Integer) pageContext.getAttribute("varName");
                                        MedicamentCommanderDAO M=new MedicamentCommanderDAO(); %>
                                      <%=M.Qte_com(varName) %>
                                   </td>
                                   <td>
                                    <c:out value="${a.getPrix_comm() }"/>DH
                                   </td>
                                      <td >
                                   <c:out value="${a.getDate_comm()}"/>
                                   </td>
                                   
                                   
                                   
                                   <td class="modI">
                                   
                                                <c:choose>
                                             <c:when test="${a.getOrd().getFichier_ord()!=null}" >
                                              <form action="" method="post">
                                            <input type="hidden" name="fic" value="<c:out value="${a.getOrd().getFichier_ord()}"/>">
                                            <button><i class="fa-solid fa-file-arrow-down"></i></button>
                                            </form>
                                                      </c:when>
                                                         <c:otherwise>
                                                           -----
                                                          </c:otherwise>
                                                    </c:choose>
                                      </td> 
                                       <td class="mod">
                                         <form action="" method="post">
                                            <input type="hidden" name="id_comm" value="<c:out value="${a.getId_comm()}"/>">
                                            <input type="hidden" name="anva" value="3">
                                            <button><i class="fa-solid fa-check-to-slot"></i></button>
                                            </form>
                                   </td>
                                    <td class="supp">
                                    <form action="" method="post">
                                            <input type="hidden" name="id_comm" value="<c:out value="${a.getId_comm()}"/>">
                                            <input type="hidden" name="anva" value="4">
                                            <button><i class="fa-solid fa-rectangle-xmark"></i></button>
                                            </form>
                                   
                                   </td>
					   </tr>
                                       
                    </c:forEach>
                  </c:if>                     
                                   
                   </tbody>
          </table>
                           
    </div>