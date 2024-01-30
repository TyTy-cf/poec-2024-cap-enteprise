<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../tag.jsp" %>
<c:set var="title" scope="request" value="Se connecter"/>
<jsp:include flush="true" page="../base.jsp"/>

<div class="container">
  <form method="POST" action="${UrlRoute.URL_LOGIN}" class="col-4 mx-auto mt-5">
    <h1 class="form-heading">Se connecter</h1>
    <div class="form-group ${error != null ? 'has-error' : ''}">
      <span>${message}</span>
      <input autocomplete="off" name="username" type="text" class="form-control mb-3" placeholder="Pseudo"/>
      <input autocomplete="off" name="password" type="password" class="form-control" placeholder="Mot de passe"/>
      <p class="invalid-feedback">${error}</p>
      <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
      <button class="btn btn-lg btn-primary btn-block" type="submit">
        Se connecter <i class="fa-solid fa-right-to-bracket"></i>
      </button>
      <h4 class="text-center mt-3">
        <a href="${UrlRoute.URL_REGISTER}" class="btn-link">
          S'inscrire <i class="fa-solid fa-user-plus"></i>
        </a>
      </h4>
    </div>
  </form>
</div>

<%@ include file="../footer.jsp" %>