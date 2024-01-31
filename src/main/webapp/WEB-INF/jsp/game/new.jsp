<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../tag.jsp" %>
<c:set var="title" scope="request" value="Nouveau jeu"/>
<jsp:include flush="true" page="${contextPath}/WEB-INF/jsp/base.jsp"/>

<div class="container mt-5">
    <nav aria-label="breadcrumb">
        <ol class="breadcrumb">
            <li class="breadcrumb-item"><a class="btn-link" href="${contextPath}/">Accueil</a></li>
            <li class="breadcrumb-item"><a class="btn-link" href="${contextPath}${UrlRoute.URL_GAME}">Les jeux</a></li>
            <li class="breadcrumb-item active" aria-current="page">Nouveau jeu</li>
        </ol>
    </nav>

    <h1 class="my-4 text-center">Ajouter un jeu</h1>

    <f:form method="POST" modelAttribute="gameDto" class="col-lg-8 col-md-10 col-sm-12 mx-auto">
        <div class="row mb-3">
            <div class="col-md-8 col-sm-12">
                <f:label class="col-form-label" path="name">Nom</f:label>
                <f:input type="text" path="name"
                         class="form-control"
                         placeholder="Nom"
                         autofocus="true"/>
                <f:errors path="name" cssClass="invalid-feedback"/>
            </div>
            <div class="col-md-4 col-sm-12">
                <f:label class="col-form-label" path="publishedAt">Date de sortie</f:label>
                <f:input type="date" path="publishedAt"
                         class="form-control"
                         autofocus="true"/>
                <f:errors path="publishedAt" cssClass="invalid-feedback"/>
            </div>
        </div>
        <div class="row mb-3">
            <div class="col-md-4 col-sm-12">
                <f:label class="col-form-label" path="genre">
                    Genre
                </f:label>
                <f:select path="genre"
                          items="${genres}"
                          cssClass="form-select"
                          itemLabel="name"
                >
                </f:select>
                <f:errors path="genre" cssClass="invalid-feedback"/>
            </div>
            <div class="col-md-4 col-sm-12">
                <f:label class="col-form-label" path="classification">
                    Classification
                </f:label>
                <f:select path="classification"
                          items="${classifications}"
                          cssClass="form-select"
                          itemLabel="name"
                >
                </f:select>
                <f:errors path="classification" cssClass="invalid-feedback"/>
            </div>
            <div class="col-md-4 col-sm-12">
                <f:label class="col-form-label" path="businessModel">
                    Modèle économique
                </f:label>
                <f:select path="businessModel"
                          items="${businessModels}"
                          cssClass="form-select"
                          itemLabel="name"
                >
                </f:select>
                <f:errors path="businessModel" cssClass="invalid-feedback"/>
            </div>
        </div>
        <div class="row mb-3">
            <div class="col-md-6 col-sm-12">
                <f:label class="col-form-label" path="publisher">
                    Editeur
                </f:label>
                <f:select path="publisher"
                          items="${publishers}"
                          cssClass="form-select"
                          itemLabel="name"
                >
                </f:select>
                <f:errors path="publisher" cssClass="invalid-feedback"/>
            </div>
            <div class="col-md-6 col-sm-12">
                <f:label class="col-form-label" path="platforms">
                    Plateformes
                </f:label>
                <input class="form-control" data-multiple-select-input="platforms"/>
                <f:select path="platforms"
                          items="${platforms}"
                          cssClass="form-select"
                          itemLabel="name"
                          data-multiple-select="platforms"
                >
                </f:select>
                <f:errors path="platforms" cssClass="invalid-feedback"/>
            </div>
        </div>
        <div class="col-12 mb-3">
            <f:label class="col-form-label" path="description">Description</f:label>
            <f:textarea type="text" path="description"
                        class="form-control"
                        placeholder="Description"
                        autofocus="true"/>
            <f:errors path="description" cssClass="invalid-feedback"/>
        </div>
        <button class="btn btn-lg btn-primary btn-block" type="submit">
            Valider
        </button>
    </f:form>
</div>

<%@ include file="../footer.jsp" %>
