<!DOCTYPE html>
<html class="uk-height-1-1">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>ANSC</title>

<!-- link all the styles -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/uikit/2.27.5/css/uikit.gradient.css" />
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/uikit/2.27.5/css/components/sticky.gradient.css">
<link rel="stylesheet" href="assets/css/master.css">

<!-- link all the scripts -->
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/uikit/2.27.5/js/uikit.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/uikit/2.27.5/js/components/sticky.js"></script>
<script src="assets/js/myScripts.js"></script>

</head>
<body class="uk-height-1-1">
	<div class="uk-vertical-align uk-text-center uk-height-1-1">
		<div class="uk-vertical-align-middle" style="width: 250px;">
			<img class="uk-margin-bottom" width="140" height="120"
				src="assets/images/back1.PNG" alt="">
			<form class="uk-panel uk-panel-box uk-form" action="login" method="post">
				<div class="uk-form-row">
					<input class="uk-width-1-1 uk-form-large" type="text" name="loginuser"
						placeholder="Usuario">
				</div>
				<div class="uk-form-row">
					<input class="uk-width-1-1 uk-form-large" type="password" name="loginpassword"
						placeholder="Contraseña">
				</div>
				<div class="uk-form-row">
					<button class="uk-width-1-1 uk-button uk-button-primary uk-button-large"
						type="submit" >Login</button>
				</div>
				<div class="uk-form-row uk-text-small">
					<a class="uk-float-right uk-link uk-link-muted" href="#modal"
						data-uk-modal>Olvido Contraseña?</a>
				</div>
			</form>

		</div>
	</div>
	<div id="modal" class="uk-modal">
		<div class="uk-modal-dialog">
			<a href="" class="uk-modal-close uk-close"></a>
			<h1>Contacte a un Administrador</h1>
			<p>Esta tarea aun no esta diseñada para personal no calificaso</p>
		</div>
	</div>
</body>
</html>
