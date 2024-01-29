<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../tag.jsp" %>
<c:set var="title" scope="request" value="Avis"/>
<jsp:include flush="true" page="${contextPath}/WEB-INF/jsp/base.jsp"/>

<div class="container">
    <div class="d-flex justify-content-end mt-4">
        page ${pageGames.number + 1} sur ${pageGames.totalPages}
    </div>

    <table class="table table-striped table-hover">
        <thead>
            <tr>
                <th>
                    <!-- Label à afficher -->
                    <c:set var="label" scope="request" value="Nom"/>
                    <!-- Sur quelle propriété de l'objet on souhaite trier -->
                    <c:set var="sortable" value="name"/>
                    <%@ include file="../../component/sortable.jsp" %>
                </th>
                <th>
                    <!-- Label à afficher -->
                    <c:set var="label" scope="request" value="Date"/>
                    <!-- Sur quelle propriété de l'objet on souhaite trier -->
                    <c:set var="sortable" value="publishedAt"/>
                    <%@ include file="../../component/sortable.jsp" %>
                </th>
                <th>
                    <!-- Label à afficher -->
                    <c:set var="label" scope="request" value="Editeur"/>
                    <!-- Sur quelle propriété de l'objet on souhaite trier -->
                    <c:set var="sortable" value="publisher.name"/>
                    <%@ include file="../../component/sortable.jsp" %>
                </th>
                <th>
                    <!-- Label à afficher -->
                    <c:set var="label" scope="request" value="Genre"/>
                    <!-- Sur quelle propriété de l'objet on souhaite trier -->
                    <c:set var="sortable" value="genre.name"/>
                    <%@ include file="../../component/sortable.jsp" %>
                </th>
                <th>
                    <span class="mt-3">
                        <a href="${currentUrl}" class="btn-link">
                            Reset
                        </a>
                    </span>
                </th>
            </tr>
        </thead>
        <tbody>
        <c:forEach items="${pageGames.content}" var="game">
            <tr>
                <td>${game.name}</td>
                <td>${game.publishedAt}</td>
                <td>${game.publisher.name}</td>
                <td>${game.genre.name}</td>
                <td></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <c:set var="page" scope="request" value="${pageGames}"/>
    <%@ include file="../../component/pagination.jsp" %>

</div>

<%@ include file="../../footer.jsp" %>
