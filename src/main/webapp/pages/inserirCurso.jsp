

<%@page import="model.Curso"%>
<%@page import="dao.CursoDao"%>
<%@ include file="header.jsp"%>

<style>
.container {
	margin-top: 80px;
	margin-bottom: 20px
}
</style>

<!-- <fmt:formatDate value="${empresa.dataAbertura }" pattern="dd/MM/yyyy"/> -->

<%
String id = request.getParameter("id");

if (id != null) {
	
	CursoDao dao = new CursoDao();

	Curso curso = dao.buscarCursoId(Integer.parseInt(id));
	
	
%>

<div class="container">
	<form
		action="${pageContext.request.contextPath}/update"
		method="post">
		<div class="row">
			<div class=col-2></div>
			<div class=col-8>
				<div class="input-group mb-3">
					<input name="id" id="id" type="hidden" value="<%=curso.getIdCurso()%>"> <label
						class="input-group-text" for="inputGroupSelect01">Cursos</label> 
					<select
						class="form-select" id="nome_curso" name="nome_curso"
						required="required">
						<option selected disabled="disabled" value="">Selecione o
							curso para alterar...</option>
						<option value="java" >JAVA</option>
						<option value="javascript">JavaScript</option>
						<option value="c++">C++</option>
						<option value="phython">Phython</option>
						<option value="html">HTML</option>
						<option value="css">CSS</option>

					</select>
				</div>

				<label for="inputPassword5" class="form-label">Data Curso</label> <input
					type="date" id="data_curso" name="data_curso" class="form-control"
					required="required" value="<%=curso.getDataCurso()%>"
					aria-describedby="passwordHelpBlock" /> <label
					for="inputPassword5" class="form-label">Hora Curso</label> <input
					type="time" id="hora_curso" name="hora_curso" required="required"
					value="<%=curso.getHoraCurso()%>" class="form-control"
					aria-describedby="passwordHelpBlock" /> <label
					for="inputPassword5" class="form-label">Duração do Curso</label> <input
					type="number" id="duracao_curso" name="duracao_curso"
					required="required" value="<%=curso.getDuracaoCurso()%>"
					class="form-control" aria-describedby="passwordHelpBlock" />

				<div class="mb-3">
					<label for="exampleFormControlTextarea1" class="form-label">Resumo
						do Curso</label>
					<textarea class="form-control" name="resumo_curso"
						required="required" id="resumo_curso" rows="3"><%=curso.getResumoCurso()%> </textarea>
				</div>

				<button type="submit" class="btn btn-warning">Alterar</button>
				<a href="pesquisarCurso.jsp" class="btn btn-info">Voltar</a>


			</div>
			<div class=col-2></div>

		</div>
		
		
	</form>
</div>

<%
} else {
%>
<div class="container">
	<form action="${pageContext.request.contextPath}/inserir" method="post">
		<div class="row">
			<div class=col-2></div>
			<div class=col-8>
				<div class="input-group mb-3">
					<label class="input-group-text" for="inputGroupSelect01">Cursos</label>
					<select class="form-select" required="required" id="nome_curso"
						name="nome_curso">
						<option selected disabled="disabled" value="">Escolha o
							seu curso...</option>

						<option value="java">JAVA</option>
						<option value="javascript">JavaScript</option>
						<option value="c++">C++</option>
						<option value="phython">Phython</option>
						<option value="html">HTML</option>
						<option value="css">CSS</option>

					</select>
				</div>

				<label for="inputPassword5" class="form-label">Data Curso</label> <input
					type="date" id="data_curso" name="data_curso" required="required"
					class="form-control" aria-describedby="passwordHelpBlock" /> <label
					for="inputPassword5" class="form-label">Hora Curso</label> <input
					type="time" id="hora_curso" name="hora_curso" required="required"
					class="form-control" aria-describedby="passwordHelpBlock" /> <label
					for="inputPassword5" class="form-label">Duração do Curso</label> <input
					type="number" id="duracao_curso" name="duracao_curso"
					required="required" class="form-control"
					aria-describedby="passwordHelpBlock" />

				<div class="mb-3">
					<label for="exampleFormControlTextarea1" class="form-label">Resumo
						do Curso</label>
					<textarea class="form-control" name="resumo_curso"
						required="required" id="resumo_curso" rows="3"  ></textarea>
				</div>

				<button type="submit" class="btn btn-primary">Enviar</button>
				<a href="pesquisarCurso.jsp" class="btn btn-info">Voltar</a>

			</div>
			<div class=col-2></div>

		</div>
	</form>
</div>


<%
}
%>

<%@ include file="footer.jsp"%>
