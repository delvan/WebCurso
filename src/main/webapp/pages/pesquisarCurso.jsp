
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
							<%=curso.getNome_curso()%>
						</h5>
						<p class="card-text">
							<%=curso.getResumo_curso()%>
						</p>
						<p class="card-text">
							<small class="text-muted">Duracão curso: <%=curso.getDuração_curso()%>
							</small> <br> 
							
							<small class="text-muted">Inicio Curso: <%=curso.getData_curso()%></small>
							
							<small class="text-muted">Duracão curso: <%=curso.getDuração_curso()%> h </small>
						</p>

						<a id="id_curso" href="inserirCurso.jsp?id=<%=curso.getId_curso()%>"
							class="btn btn-success">Alterar</a> 
							
						<a href="#" class="btn btn-danger">Remover</a>


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
