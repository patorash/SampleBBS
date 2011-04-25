<%@page pageEncoding="UTF-8" isELIgnored="false" session="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="f" uri="http://www.slim3.org/functions"%>

<c:import url="/layout.jsp">
	<c:param name="description" value="これはGAE開発入門用のサンプルです。" />
	<c:param name="keywords" value="GoogleAppEngine, 四国GTUG" />
	<c:param name="content">
	<h2>${f:h(bbs.title)}</h2>
	<dl>
		<dt>投稿者：${f:h(bbs.name)} (${f:h(bbs.createdString)})</dt>
		<dd>${f:br(f:h(bbs.body))}</dd>
	</dl>
	<form method="post" action="/delete/${bbs.key.id}">
		<p>
		<input type="hidden" name="token" value="${token}" />
		<input type="text" style="display: none"/>
			<input type="password" class="short" ${f:text("password")}/>
			<c:if test="${not empty errors.password}">
				<span class="err">削除キーが違います</span>
			</c:if>
		<input type="submit" value="削除" />
		</p>
	</form>
	<hr />
	<dl class="comment">
	<c:forEach var="comment" items="${comments}">
		<dt>投稿者：${f:h(comment.name)} (${f:h(comment.createdString)})</dt>
		<dd>${f:br(f:h(comment.body))}</dd>
	</c:forEach>
	</dl>
	<h3>コメント投稿</h3>
	<a name="commentform"></a>
	<c:if test="${not empty errors.token}">
		<span class="err">トークンが不正です。</span>
	</c:if>
	<form method="post" action="/comment/${f:h(bbs.key.id)}">
		<input type="hidden" name="token" value="${token}" />
		<dl>
			<dt>お名前 <span class="required">(必須)</span></dt>
			<dd><input type="text" ${f:text("name")} />
			<c:if test="${not empty errors.name}">
				<span class="err">${errors.name}</span>
			</c:if>
			</dd>
			<dt>コメント <span class="required">(必須)</span><dt>
			<dd><textarea name="body">${f:h(param.body)}</textarea>
			<c:if test="${not empty errors.body}">
				<span class="err">${errors.body}</span>
			</c:if>
			</dd>
		</dl>
		<input type="submit" value=" 投稿する " />
	</form>
	</c:param>
</c:import>