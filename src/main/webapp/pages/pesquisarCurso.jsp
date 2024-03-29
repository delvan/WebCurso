
<%@page import="java.util.List"%>
<%@page import="model.Curso"%>
<%@page import="dao.CursoDao"%>
<%@ include file="header.jsp"%>

<style>
.container {
	margin-top: 80px;
	margin-bottom: 20px
}

.col-4 {
	padding: 4px;
}
</style>

<div class="container">

	<%
	CursoDao dao = new CursoDao();

	List<Curso> listCurso = dao.listar();
	%>


	<div class="row">

		<%
		for (int i = 0; i < listCurso.size(); i++) {

			Curso curso = listCurso.get(i);
		%>

		<div class="col-4">
			<div class="card-group">
				<div class="card">
					<!--  	<img src="..." class="card-img-top" alt="..."> -->
					<div class="card-body">
						<h5 class="card-title">
							<%=curso.getNomeCurso()%>
						</h5>
						<p class="card-text">
							<%=curso.getResumoCurso()%>
						</p>
						<p class="card-text">
							<small class="text-muted">Durac�o curso: <%=curso.getDuracaoCurso()%>
							</small> <br> <small class="text-muted">Inicio Curso: <%=curso.getDataCurso()%></small>

							<small class="text-muted"> Durac�o curso: <%=curso.getDuracaoCurso()%> hora(s)

							</small>
						</p>

						<a id="id_curso"
							href="inserirCurso.jsp?id=<%=curso.getIdCurso()%>"
							class="btn btn-success">Alterar</a> <a class="btn btn-danger"
							href="${pageContext.request.contextPath}/delete?id=<%=curso.getIdCurso()%>">Remover</a>


					</div>
				</div>

			</div>
		</div>





		<%
		}
		%>

	</div>

</div>

<%@ include file="footer.jsp"%>
