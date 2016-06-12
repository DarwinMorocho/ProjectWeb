	function addRow(tableID) {
			var table = document.getElementById(tableID);
			var rowCount = table.rows.length;
			var row = table.insertRow(rowCount);
			var cell1 = row.insertCell(0);
			var element1 = document.createElement("input");
			element1.type = "text";
			element1.name="txtbox1";
			element1.value=document.getElementById(1).value;
			
			cell1.appendChild(element1);
			var cell2 = row.insertCell(1);
		    var element2 = document.createElement("input");
			element2.type = "text";
			element2.name = "txtbox2";
			element2.value=document.getElementById(2).value;
			cell2.appendChild(element2);
			var cell3 = row.insertCell(2);
			var element3 = document.createElement("input");
			element3.type = "text";
			element3.name = "txtbox3";
			element3.value=document.getElementById(3).value;
			cell3.appendChild(element3);
			
			var cell4 = row.insertCell(3);
			var element4 = document.createElement("input");
			element4.type = "text";
			element4.name = "txtbox4";
			element4.value=document.getElementById(4).value;
			cell4.appendChild(element4);
			
			var cell5 = row.insertCell(4);
			var element5 = document.createElement("input");
			element5.type = "text";
			element5.name = "txtbox5";
			element5.value=document.getElementById(5).value;
			cell5.appendChild(element5);
			
			document.getElementById(1).value= "";
			document.getElementById(2).value= "";
			document.getElementById(3).value= "";
			document.getElementById(4).value= "";
			document.getElementById(5).value= "";
		}
		function deleteRow(tableID) {
			try {
			var table = document.getElementById(tableID);
			var rowCount = table.rows.length;
			for(var i=0; i<rowCount; i++) {
				var row = table.rows[i];
				var chkbox = row.cells[0].childNodes[0];
				if(null != chkbox && true == chkbox.checked) {
					table.deleteRow(i);
					rowCount--;
					i--;
				}
			}
			}catch(e) {
				alert(e);
			}
		}