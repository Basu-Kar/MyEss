 function getNewSubmitForm()
	{
		var submitForm = document.createElement("FORM");
		document.body.appendChild(submitForm);
		submitForm.method = "POST";
		return submitForm;
	}

	function submitForm(actionUrl){
		var menuForm=getNewSubmitForm();
		menuForm.action= actionUrl;
		menuForm.submit();
	}
