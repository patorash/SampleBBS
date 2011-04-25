<%@page pageEncoding="UTF-8" isELIgnored="false" session="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="f" uri="http://www.slim3.org/functions"%>

<c:import url="/layout.jsp">
	<c:param name="description" value="これはGAE開発入門用のサンプルです。" />
	<c:param name="keywords" value="GoogleAppEngine, 四国GTUG" />
	<c:param name="content">
	<h2>スレッド一覧</h2>
	<p><a href="/create">新規スレッド作成</a></p>
	<dl class="list">
	<c:forEach var="thread" items="${list}">
		<dt><a href="/read/${thread.key.id}">${f:h(thread.title)}</a></dt>
		<dd>投稿者：${f:h(thread.name)} ${f:h(thread.createdString)}</dd>
	</c:forEach>
	</dl>
	<p><a href="/create">新規スレッド作成</a></p>
	</c:param>
</c:import>