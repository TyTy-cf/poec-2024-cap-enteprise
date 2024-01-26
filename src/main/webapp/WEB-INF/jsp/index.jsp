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
                <a href="${currentUrl}" class="btn-link">
                    Reset
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
                <div class="main-review-card w-100">
                    <p class="text-center">
                        Le ${dateUtils.getDateFormat(review.createdAt, "dd/MM/yyyy")}
                        par <a class="btn-link" href="#">${review.gamer.nickname}</a>
                        <c:if test="${review.moderator != null}">
                            <i class="fa-solid fa-check"></i>
                        </c:if>
                    </p>
                    <div class="review-card w-100">
                        <p class="review-description">
                            ${jspUtils.excerpt(review.description, 209)}
                        </p>
                        <div class="d-flex justify-content-between">
                            <p class="${jspUtils.getCssClas(review.rating)}">
                                ${jspUtils.getStringRating(review.rating)} / 20
                            </p>
                            <a class="btn-link" href="#">
                                ${review.game.name}
                            </a>
                        </div>
                    </div>
                </div>
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
