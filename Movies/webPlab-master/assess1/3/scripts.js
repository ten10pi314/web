function findans()
{
	var n=(document.getElementById("n").value);
	
	var a=[50,20,10,5,2];
	
	var ans=""
	var i=0;
	while(n>0)
	{
		if(n==1)
		{
			ans="no denominations can be given";
			break;
		}
		if(a[i]>n)
		{
			
			count=0;
			i++;
		}
		else
		{
			n-=a[i];
			ans=ans+","+a[i];
		}
		
	}
		
	
	document.getElementById("ans").innerHTML="ans:"+ans;
}

function findmedicine()
{
	var disease=(document.getElementById("disease").value);
	var ans;
	if(disease=="cold")
		ans="vicks"
	else if(disease=="headache")
		ans="calpaul"
	else if(disease=="stomachpain")
		ans="gelusil"
	else
		ans="can't be decided,contact our customer care";
	
	document.getElementById("dans").innerHTML="Medicine :"+ans;
}

function ram()
{
	alert("Pho:4546\naddress:21,Guindy");
}

function gugan()
{
	alert("Pho:12346\naddress:21,Chrompet");
}

function diwa()
{
	alert("Pho:4343546\naddress:23,Tambaram");
}

function arjun()
{
	alert("Pho:12124546\naddress:77,Pallavaram");
}
