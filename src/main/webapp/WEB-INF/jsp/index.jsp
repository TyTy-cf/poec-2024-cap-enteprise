<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="tag.jsp" %>
<c:set var="title" scope="request" value="Avis"/>
<jsp:include flush="true" page="${contextPath}/WEB-INF/jsp/base.jsp"/>

<div class="container mt-5">
    <nav aria-label="breadcrumb">
        <ol class="breadcrumb">
            <li class="breadcrumb-item active" aria-current="page">Accueil</li>
            <li class="breadcrumb-item"><a class="btn-link" href="${contextPath}${UrlRoute.URL_GAME}">Les jeux</a></li>
        </ol>
    </nav>
    <div class="d-flex justify-content-between">
        <div class="d-flex">
            <!-- Label à afficher -->
            <c:set var="label" scope="request" value="Date"/>
            <!-- Sur quelle propriété de l'objet on souhaite trier -->
            <c:set var="sortable" value="createdAt"/>
            <%@ include file="component/sortable.jsp" %>

            <c:set var="label" scope="request" value="Note"/>
            <c:set var="sortable" value="rating"/>
            <%@ include file="component/sortable.jsp" %>

            <c:set var="label" scope="request" value="Jeu"/>
            <c:set var="sortable" value="game.name"/>
            <%@ include file="component/sortable.jsp" %>

            <c:set var="label" scope="request" value="Joueur"/>
            <c:set var="sortable" value="gamer.nickname"/>
            <%@ include file="component/sortable.jsp" %>

            <%@ include file="component/filter-reset.jsp" %>
        </div>

        <c:set var="page" scope="request" value="${pageReviews}"/>
        <%@ include file="component/pagination-number.jsp" %>
    </div>
    <div class="row">
        <c:forEach items="${pageReviews.content}" var="review">
            <div class="col-lg-4 col-md-6 col-sm-12 mt-4">
                <%@ include file="component/entity/review-card.jsp" %>
            </div>
        </c:forEach>
    </div>
    <div>
        <a href="${UrlRoute.URL_EXPORT}" class="btn btn-link">
            <i class="fa-solid fa-file-excel me-1"></i>
            Télécharger export Excel
        </a>
    </div>
    <%@ include file="component/pagination.jsp" %>
</div>

<%@ include file="footer.jsp" %>
