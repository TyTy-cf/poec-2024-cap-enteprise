<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="tag.jsp" %>
<c:set var="title" scope="request" value="Avis"/>
<jsp:include flush="true" page="${contextPath}/WEB-INF/jsp/base.jsp"/>

<div class="container">
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

            <span class="mt-auto mb-2">
                <a href="${currentUrl}" class="btn-link" title="Réinitialiser les filtres">
                    <i class="fa fa-filter-circle-xmark"></i>
                </a>
            </span>
        </div>
        <div  class="mt-auto mb-2">
            <span>
                page ${pageReviews.number + 1} sur ${pageReviews.totalPages}
            </span>
        </div>
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
    <c:set var="page" scope="request" value="${pageReviews}"/>
    <%@ include file="component/pagination.jsp" %>

</div>

<%@ include file="footer.jsp" %>


<%--<div class="background-container">--%>
<%--    <video class="w-100" id="background-video1" autoplay loop muted>--%>
<%--        <source src="https://www.leagueoflegends.com/static/hero-3e934348790824f4b800524f96a93020.mp4" type="video/mp4">--%>
<%--    </video>--%>
<%--</div>--%>
<%--<div class="container" id = "container-video">--%>
<%--    <div class="row d-none d-sm-block d-lg-block">--%>
<%--        <video class="w-100" id="background-video" autoplay loop muted>--%>
<%--            <source id="background-video2" src="https://www.leagueoflegends.com/static/hero-3e934348790824f4b800524f96a93020.mp4" type="video/mp4">--%>
<%--        </video>--%>
<%--        <div class="position-relative">--%>
<%--            <div class="position-absolute bottom-0 start-0"  id ="content">--%>
<%--                <h1 class="display-3">--%>
<%--                    <span class="fw-bold" style="color: orange;">H</span><span class="fw-bolder" style="color: #fff;">GAMES</span>--%>
<%--                </h1>--%>
<%--                <form class="d-flex py-2 px-2" role="search">--%>
<%--                    <button class="btn btn-outline-success bolder btn-sm " type="submit" id ="btn-navbar">CONNEXION</button>--%>
<%--                </form>--%>
<%--            </div>--%>
<%--        </div>--%>
<%--    </div>--%>
<%--</div>--%>

