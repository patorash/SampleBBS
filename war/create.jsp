<%@page pageEncoding="UTF-8" isELIgnored="false" session="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="f" uri="http://www.slim3.org/functions"%>

<c:import url="/layout.jsp">
	<c:param name="description" value="これはGAE開発入門用のサンプルです。" />
	<c:param name="keywords" value="GoogleAppEngine, 四国GTUG" />
	<c:param name="content">
	<h2>スレッド作成</h2>
	<form method="post" action="/create">
	<input type="hidden" name="token" value="${token}" />
	<dl id="create_form">
		<dt>タイトル <span class="required">(必須)</span></dt>
		<dd>
			<input type="text" ${f:text("title")} class="normal" />
			<c:if test="${not empty errors.title}">
				<span class="err">${errors.title}</span>
			</c:if>
		</dd>
		<dt>お名前 <span class="required">(必須)</span></dt>
		<dd><input type="text" class="normal" ${f:text("name")} />
			<c:if test="${not empty errors.name}">
				<span class="err">${errors.name}</span>
			</c:if>
		</dd>
		<dt>本文 <span class="required">(必須)</span></dt>
		<dd><textarea name="body" class="largetext">${f:h(body)}</textarea>
			<c:if test="${not empty errors.body}">
				<span class="err">${errors.body}</span>
			</c:if>
		</dd>
		<dt>削除パスワード（※未設定だと後で削除不可）</dt>
		<dd><input type="password" class="short" ${f:text("password")}/></dd>
	</dl>
	<input type="submit" value=" 投稿する " />
	</form>
	<p><a href="/">戻る</a></p>
	</c:param>
</c:import>