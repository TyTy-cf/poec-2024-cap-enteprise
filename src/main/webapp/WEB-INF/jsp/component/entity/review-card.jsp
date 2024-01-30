<%@ page contentType="text/html;charset=UTF-8" %>

<div class="main-review-card w-100">
    <p class="text-center">
        Le ${dateUtils.getDateFormat(review.createdAt, "dd/MM/yyyy")}
        par <a class="btn-link" href="${UrlRoute.URL_USER}/${userLogged.uuid}">${review.gamer.nickname}</a>
        <c:if test="${review.moderator != null}">
            <i class="fa-solid fa-circle-check rating-20" title="Commentaire modéré"></i>
        </c:if>
        <c:if test="${review.moderator == null}">
            <i class="fa-solid fa-circle-xmark rating-5" title="En attente de modération..."></i>
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
            <a class="btn-link" href="${UrlRoute.URL_GAME}/${review.game.slug}">
                ${review.game.name}
            </a>
        </div>
        <c:if test="${review.moderatedAt == null && userLogged.admin}">
            <a class="btn btn-link rating-20" href="${UrlRoute.URL_REVIEW}/${review.id}/1">
                accepter
            </a>
             /
            <a class="btn btn-link rating-5" href="${UrlRoute.URL_REVIEW}/${review.id}/0">
                refuser
            </a>
        </c:if>
    </div>
</div>
