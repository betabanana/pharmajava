                             <div class="table" id="table">

                            <table>
                                <thead>
                                    <tr>
                                        <td>Titre</td>
                                        <td>Prix</td>
                                        <td>Nembre d'instance</td>
                                        <td> </td>
                                         <td> </td>
                                        <td> </td>
                                    </tr>
                                </thead>
                                <tbody>
                                
                                   <c:if test="${med!=null}">
                                   <c:forEach items="${med}" var="a">
                                   <tr> 
                                   <td class="aff">
                                    <form action="AdminMedicamentaff" method="post">
                                            <input type="hidden" name="id_med" value="<c:out value="${a.getId_med()}"/>">
                                            <input type="hidden" name="gere" value="5">
                                            <button><c:out value="${a.getTitre_med() }"/> </button>
                                            </form>
                                   </td>
                                   <td class="aff">
                                    <form action="AdminMedicamentaff" method="post">
                                            <input type="hidden" name="id_med" value="<c:out value="${a.getId_med()}"/>">
                                            <input type="hidden" name="gere" value="5">
                                            <button><c:out value="${a.getPrix_med() }"/> DH </button>
                                            </form>
                                   </td>
                                   <td class="aff">
                                    <form action="AdminMedicamentaff" method="post">
                                            <input type="hidden" name="id_med" value="<c:out value="${a.getId_med()}"/>">
                                            <input type="hidden" name="gere" value="5">
                                            <button><c:out value="${a.getNbr_Instante() }"/> </button>
                                            </form>
                                   </td>
                                        
                                         <td class="mod">
                                                <form action="" method="post">
                                            <input type="hidden" name="id_med" value="<c:out value="${a.getId_med()}"/>">
                                            <input type="hidden" name="gere" value="2">
                                            <button><label for="modife"><i class="fa-solid fa-pencil"></i></label></button>
                                            </form>
                                        </td>
                                        <td class="supp">
                                           <form action="" method="post">
                                            <input type="hidden" name="id_med" value="<c:out value="${a.getId_med()}"/>">
                                            <input type="hidden" name="gere" value="3">
                                            <button><label for="modife"><i class="fa-solid fa-trash-can"></i></label></button>
                                            </form>
                                            
                                            
                                          </td>
						<td class="modI">
							<form action="" method="post">
								<input type="hidden" name="id_med" value="<c:out value="${a.getId_med()}"/>">
								<input type="hidden" name="gere" value="1">
								<button>
									<i class="fa-solid fa-plus-minus"></i>
								</button>
							</form>
						</td>

					</tr>
                                       
                                    <%-- <div class="container"> 
                                        <input class="AjouterMedInput_Inst" type="checkbox" id="AjoueterInst">
                                          <%@ include file="ajouterInstance.jsp" %> 
                                          </div>--%>
                                   </c:forEach>
                                   </c:if>
                                 </tbody>
                            </table>
                           
                        </div>