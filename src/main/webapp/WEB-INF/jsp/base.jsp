<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="tag.jsp" %>
<%
    Object title = request.getAttribute("title");
    if (title == null) {
        title = "Avis";
    }
    request.setAttribute("title", title);
%>

<html>
    <head>
        <title>${title}</title>
        <link href="${contextPath}/css/main.css" rel="stylesheet">
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css" rel="stylesheet">
        <script type="text/javascript" src="${contextPath}/js/init-sortable.js"></script>
        <script type="text/javascript" src="${contextPath}/js/hide-form.js"></script>
        <script type="text/javascript" src="${contextPath}/js/alert.js"></script>
    </head>
    <body>
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
        <div class="row w-100">
            <div class="col-2">
                <a class="navbar-brand ms-3" href="${contextPath}/">
                    <i class="fa-brands fa-steam fa-3x"></i>
                </a>
            </div>
            <div class="col-2">
            </div>
            <div class="col-4">
                <security:authorize access="isAuthenticated()">
                    <div class="main-container p-2">
                        <div class="d-flex">
                            <input type="text"
                                   class="form-control"
                                   placeholder="Starcraft, FPS, ..."
                                   data-search-bar-games
                            >
                            <a class="my-auto me-3">
                                <i class="fa fa-magnifying-glass"></i>
                            </a>
                        </div>
                        <div class="search-response-container">
                        </div>
                    </div>
                </security:authorize>
            </div>
            <div class="col-4 my-auto">
                <security:authorize access="!isAuthenticated()">
                    <div class="d-flex justify-content-end">
                        <a class="nav-link me-3" href="${UrlRoute.URL_REGISTER}" title="S'inscrire">
                            <i class="fa-solid fa-user-plus fa-2x"></i>
                        </a>
                        <a class="nav-link" href="${UrlRoute.URL_LOGIN}" title="Se connecter">
                            <i class="fa-solid fa-right-to-bracket fa-2x"></i>
                        </a>
                    </div>
                </security:authorize>
                <security:authorize access="isAuthenticated()">
                    <div class="d-flex justify-content-end">
                        <span class="ms-2">
                            Bienvenue
                            <a class="logged-user btn-link" href="${UrlRoute.URL_USER}/${userLogged.uuid}">
                                ${userLogged.nickname}
                            </a>
                        </span>
                    </div>
                    <div class="d-flex justify-content-end">
                        <form method="POST" action="${UrlRoute.URL_LOGOUT}" autocomplete="off">
                            <button type="submit" tabindex="3" class="btn btn-link" title="Se déconnecter">
                                <i class="fa-solid fa-right-from-bracket"></i>
                            </button>
                            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                        </form>
                    </div>
                </security:authorize>
            </div>
        </div>
    </nav>
    <div class="container">
        <c:if test="${requestScope.get('flashMessage') != null}">
            <div class="alert alert-${flashMessage.type}">
                    ${flashMessage.message}
            </div>
        </c:if>
    </div>