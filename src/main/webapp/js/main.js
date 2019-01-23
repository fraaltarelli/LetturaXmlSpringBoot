function leggiAllegato(){
	var path = $("#file-input").val();
	$.ajax({
		   url:"C:\Users\Francesco Altarelli\Documents\IT02355260981_0H2e7.xml",
		   dataType:"xml",
		   crossDomain: true,
		   success:function(html){
		      var allegati = $(html).find("Allegati")[0];
		      $("#p1").html(allegati);
		   }
		});
	
	
//	XmlDocument doc = new XmlDocument();
//	doc.LoadXml(path);
//	
//	
//	string jsonText = JsonConvert.SerializeXmlNode(Allegati);
	
	
	
	
//	function insertUpdateCity(id, countryCode, name, population, district) {
//		$(document).ready(function(){
//			var json = {
//					'id' : id,
//					'name' : name,
//					'district' : district,
//					'population' : population,
//					'countryCode' : countryCode
//			}
//			var jsonString = JSON.stringify(json);
//			$.ajax({
//				type: "POST",
//				url: "/api/citta/inserisci-modifica",
//				cache: false,
//				contentType: "application/json; charset=utf-8",
//				data: jsonString,
//				dataType: "json",
//				success: function (result) { 
//					citiesByCountryCode(countryCode);
//					$("#messaggioForm").text("Salvataggio riuscito della citta "+name);
//				}
//
//			});
//		})
//	}
	
	
}