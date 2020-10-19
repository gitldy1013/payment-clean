@echo off
set work_path= D:\res
D:
cd %work_path%

for /R %%s in (*.pom) do (

	cd %%~dps

	if exist %%~dpns.jar (
		curl -v -u admin:adminldy -X POST http://leg.liudongyang.top:8081/service/rest/v1/components?repository=maven-releases -F maven2.asset1=@%%~ns.jar -F maven2.asset1.extension=jar -F maven2.asset2=@%%~ns.pom -F maven2.asset2.extension=pom
	) else (
		curl -v -u admin:adminldy -X POST http://leg.liudongyang.top:8081/service/rest/v1/components?repository=maven-releases -F maven2.asset2=@%%~ns.pom -F maven2.asset2.extension=pom
	)
)

pause
