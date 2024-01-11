(function(){"use strict";var a={6098:function(a,e,t){var o=t(9242),i=t(3396);const r={id:"app"};function n(a,e,t,o,n,s){const d=(0,i.up)("MenuComponent"),l=(0,i.up)("router-view");return(0,i.wg)(),(0,i.iD)("div",r,[(0,i.Wm)(d),(0,i.Wm)(l)])}var s=t(7139),d=t.p+"img/menu.b3e3e0e7.svg",l=t.p+"img/close.fe546060.svg";const c={class:"menu navbar navbar-expand-lg navbar-dark bg-dark"},u={class:"container"},p={key:0,src:d,alt:"Menu",class:"menu-icon"},v={key:1,src:l,alt:"Close",class:"menu-icon"},g={class:"navbar-nav me-auto"},m={class:"nav-item"},h={class:"nav-item"},f={class:"nav-item"},b={class:"d-flex flex-column align-items-center"};function y(a,e,t,o,r,n){const d=(0,i.up)("router-link");return(0,i.wg)(),(0,i.iD)("nav",c,[(0,i._)("div",u,[(0,i.Wm)(d,{to:"/",class:"navbar-brand"},{default:(0,i.w5)((()=>[(0,i.Uk)("FireTrack")])),_:1}),(0,i._)("button",{class:"navbar-toggler",type:"button","data-bs-toggle":"collapse","data-bs-target":"#navbarNav","aria-controls":"navbarNav","aria-expanded":"false","aria-label":"Toggle navigation",onClick:e[0]||(e[0]=(...a)=>n.toggleMobileMenu&&n.toggleMobileMenu(...a))},[r.isMobileMenuOpen?((0,i.wg)(),(0,i.iD)("img",v)):((0,i.wg)(),(0,i.iD)("img",p))]),(0,i._)("div",{class:(0,s.C_)(["collapse navbar-collapse",{show:r.isMobileMenuOpen}]),id:"navbarNav"},[(0,i._)("ul",g,[(0,i._)("li",m,[(0,i.Wm)(d,{to:"/",class:"nav-link"},{default:(0,i.w5)((()=>[(0,i.Uk)("Home")])),_:1})]),(0,i._)("li",h,[(0,i.Wm)(d,{to:"/map",class:"nav-link"},{default:(0,i.w5)((()=>[(0,i.Uk)("Map")])),_:1})]),(0,i._)("li",f,[(0,i.Wm)(d,{to:"/profile",class:"nav-link"},{default:(0,i.w5)((()=>[(0,i.Uk)("Profile")])),_:1})])]),(0,i._)("div",b,[(0,i._)("button",{class:"btn btn-primary",onClick:e[1]||(e[1]=(...a)=>n.handleButtonClick&&n.handleButtonClick(...a))},(0,s.zw)(a.isAuthenticated?"Logout":"Login"),1)])],2)])])}t(560);var k=t(65),w={name:"MenuComponent",computed:{...(0,k.Se)(["isAuthenticated"])},data(){return{isMobileMenuOpen:!1}},methods:{handleButtonClick(){this.isAuthenticated?(this.$store.dispatch("logoutUser"),this.$router.push("/login")):this.$router.push("/login")},toggleMobileMenu(){this.isMobileMenuOpen=!this.isMobileMenuOpen}}},_=t(89);const D=(0,_.Z)(w,[["render",y],["__scopeId","data-v-8bc92952"]]);var E=D,S={name:"App",components:{MenuComponent:E}};const M=(0,_.Z)(S,[["render",n]]);var T=M,P=t(2483);const I=a=>((0,i.dD)("data-v-96977738"),a=a(),(0,i.Cn)(),a),C={class:"container"},U=(0,i.uE)('<h1 class="mt-4" data-v-96977738>FireTrack - Wildfire Management System</h1><p data-v-96977738> This system is designed to help manage wildfires with a focus on monitoring, early detection, and efficient response. </p><h2 class="mt-4" data-v-96977738>Features</h2><ul data-v-96977738><li data-v-96977738>Real-time monitoring of forest conditions.</li><li data-v-96977738>Tracking points inspections in the forest using mobile devices.</li><li data-v-96977738>Timely emergency alerts for rapid response to wildfire incidents.</li><li data-v-96977738>Fire spread projection for effective containment strategies.</li></ul><h2 class="mt-4" data-v-96977738>Sub-Systems</h2><ul data-v-96977738><li data-v-96977738><strong data-v-96977738>Web:</strong> Interactive map displaying tracking points information.</li><li data-v-96977738><strong data-v-96977738>Mobile:</strong> Tracking service for marking checked tracking points in real-time.</li><li data-v-96977738><strong data-v-96977738>Backend:</strong> Centralized database for web and mobile interfaces.</li><li data-v-96977738><strong data-v-96977738>Embedded Programming:</strong> Utilizes LoRaWAN protocol for scalable data sharing.</li></ul><h2 class="mt-4" data-v-96977738>Other</h2>',7),z=I((()=>(0,i._)("p",null,[(0,i.Uk)(" You can find Javadoc on this page: "),(0,i._)("a",{href:"https://rabeezarre.github.io/firetrack/"},"Javadoc")],-1)));function H(a,e,t,o,r,n){const s=(0,i.up)("router-link");return(0,i.wg)(),(0,i.iD)("div",C,[U,(0,i._)("p",null,[(0,i.Uk)(" You can find full documentation on this page: "),(0,i.Wm)(s,{to:"/docs"},{default:(0,i.w5)((()=>[(0,i.Uk)("Documentation Page")])),_:1})]),z])}var A={name:"HomePage"};const N=(0,_.Z)(A,[["render",H],["__scopeId","data-v-96977738"]]);var O=N;const R={className:"login-page container mt-4"},L={className:"row"},Z={className:"col-md-6 mb-4"},G={className:"col-md-6"};function F(a,e,t,o,r,n){const s=(0,i.up)("login-form"),d=(0,i.up)("registration-form");return(0,i.wg)(),(0,i.iD)("div",R,[(0,i._)("div",L,[(0,i._)("div",Z,[(0,i.Wm)(s,{onLoginSuccess:o.handleLoginSuccess},null,8,["onLoginSuccess"])]),(0,i._)("div",G,[(0,i.Wm)(d,{onRegisterSuccess:o.handleRegisterSuccess},null,8,["onRegisterSuccess"])])])])}const q=a=>((0,i.dD)("data-v-49c33ce6"),a=a(),(0,i.Cn)(),a),B={class:"login-form"},$=q((()=>(0,i._)("h2",null,"Login",-1))),j={class:"mb-3"},x=q((()=>(0,i._)("label",{for:"email",class:"form-label"},"Email",-1))),W={key:0,class:"invalid-feedback"},V={class:"mb-3"},J=q((()=>(0,i._)("label",{for:"password",class:"form-label"},"Password",-1))),Y={key:0,class:"invalid-feedback"},K={key:0,class:"alert alert-danger"},Q=q((()=>(0,i._)("button",{type:"submit",class:"btn btn-primary"},"Login",-1)));function X(a,e,t,r,n,d){return(0,i.wg)(),(0,i.iD)("div",B,[$,(0,i._)("form",{onSubmit:e[2]||(e[2]=(0,o.iM)(((...a)=>d.login&&d.login(...a)),["prevent"])),novalidate:""},[(0,i._)("div",j,[x,(0,i.wy)((0,i._)("input",{type:"email",class:(0,s.C_)(["form-control",{"is-invalid":n.emailError||n.loginError}]),id:"email","onUpdate:modelValue":e[0]||(e[0]=a=>n.credentials.email=a),required:""},null,2),[[o.nr,n.credentials.email]]),n.emailError?((0,i.wg)(),(0,i.iD)("div",W,(0,s.zw)(n.emailError),1)):(0,i.kq)("",!0)]),(0,i._)("div",V,[J,(0,i.wy)((0,i._)("input",{type:"password",class:(0,s.C_)(["form-control",{"is-invalid":n.passwordError||n.loginError}]),id:"password","onUpdate:modelValue":e[1]||(e[1]=a=>n.credentials.password=a),required:""},null,2),[[o.nr,n.credentials.password]]),n.passwordError?((0,i.wg)(),(0,i.iD)("div",Y,(0,s.zw)(n.passwordError),1)):(0,i.kq)("",!0)]),n.loginError?((0,i.wg)(),(0,i.iD)("div",K,(0,s.zw)(n.loginError),1)):(0,i.kq)("",!0),Q],32)])}var aa=t(1076),ea={data(){return{credentials:{email:"",password:""},emailError:"",passwordError:"",loginError:""}},methods:{validateEmail(){const a=/^(([^<>()\]\\.,;:\s@"]+(\.[^<>()\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;return a.test(this.credentials.email)},async login(){if(this.loginError="",this.emailError=this.validateEmail()?"":"Invalid email format",!this.emailError)try{const a=await aa.Z.post("https://firetrack.cleverapps.io/api/users/login",this.credentials);this.$store.dispatch("loginUser",a.data),this.$emit("login-success")}catch(a){a.response&&401===a.response.status?this.loginError="Invalid email or password.":this.loginError="An error occurred during login."}}}};const ta=(0,_.Z)(ea,[["render",X],["__scopeId","data-v-49c33ce6"]]);var oa=ta;const ia=a=>((0,i.dD)("data-v-b4b86c44"),a=a(),(0,i.Cn)(),a),ra={class:"registration-form"},na=ia((()=>(0,i._)("h2",null,"Register",-1))),sa={class:"mb-3"},da=ia((()=>(0,i._)("label",{for:"email",class:"form-label"},"Email",-1))),la={key:0,class:"invalid-feedback"},ca={class:"mb-3"},ua=ia((()=>(0,i._)("label",{for:"password",class:"form-label"},"Password",-1))),pa={key:0,class:"invalid-feedback"},va={class:"mb-3"},ga=ia((()=>(0,i._)("label",{for:"firstName",class:"form-label"},"First Name",-1))),ma={class:"mb-3"},ha=ia((()=>(0,i._)("label",{for:"lastName",class:"form-label"},"Last Name",-1))),fa={class:"mb-3"},ba=ia((()=>(0,i._)("label",{for:"position",class:"form-label"},"Position",-1))),ya=ia((()=>(0,i._)("option",{value:"",disabled:""},"Select position",-1))),ka=ia((()=>(0,i._)("option",{value:"Ranger"},"Ranger",-1))),wa=ia((()=>(0,i._)("option",{value:"Technician"},"Technician",-1))),_a=ia((()=>(0,i._)("option",{value:"Manager"},"Manager",-1))),Da=[ya,ka,wa,_a],Ea={key:0,class:"alert alert-danger"},Sa=ia((()=>(0,i._)("button",{type:"submit",class:"btn btn-success"},"Register",-1)));function Ma(a,e,t,r,n,d){return(0,i.wg)(),(0,i.iD)("div",ra,[na,(0,i._)("form",{onSubmit:e[5]||(e[5]=(0,o.iM)(((...a)=>d.register&&d.register(...a)),["prevent"])),novalidate:""},[(0,i._)("div",sa,[da,(0,i.wy)((0,i._)("input",{type:"email",class:(0,s.C_)(["form-control",{"is-invalid":n.emailError||n.registrationError}]),id:"email","onUpdate:modelValue":e[0]||(e[0]=a=>n.user.email=a),required:""},null,2),[[o.nr,n.user.email]]),n.emailError?((0,i.wg)(),(0,i.iD)("div",la,(0,s.zw)(n.emailError),1)):(0,i.kq)("",!0)]),(0,i._)("div",ca,[ua,(0,i.wy)((0,i._)("input",{type:"password",class:(0,s.C_)(["form-control",{"is-invalid":n.passwordError}]),id:"password","onUpdate:modelValue":e[1]||(e[1]=a=>n.user.password=a),required:""},null,2),[[o.nr,n.user.password]]),n.passwordError?((0,i.wg)(),(0,i.iD)("div",pa,(0,s.zw)(n.passwordError),1)):(0,i.kq)("",!0)]),(0,i._)("div",va,[ga,(0,i.wy)((0,i._)("input",{type:"text",class:"form-control",id:"firstName","onUpdate:modelValue":e[2]||(e[2]=a=>n.user.firstName=a),required:""},null,512),[[o.nr,n.user.firstName]])]),(0,i._)("div",ma,[ha,(0,i.wy)((0,i._)("input",{type:"text",class:"form-control",id:"lastName","onUpdate:modelValue":e[3]||(e[3]=a=>n.user.lastName=a),required:""},null,512),[[o.nr,n.user.lastName]])]),(0,i._)("div",fa,[ba,(0,i.wy)((0,i._)("select",{class:"form-control",id:"position","onUpdate:modelValue":e[4]||(e[4]=a=>n.user.position=a),required:""},Da,512),[[o.bM,n.user.position]])]),n.registrationError?((0,i.wg)(),(0,i.iD)("div",Ea,(0,s.zw)(n.registrationError),1)):(0,i.kq)("",!0),Sa],32)])}var Ta={data(){return{user:{email:"",password:"",firstName:"",lastName:"",position:"",role:"USER"},emailError:"",passwordError:"",registrationError:""}},methods:{validateEmail(){const a=/^(([^<>()\]\\.,;:\s@"]+(\.[^<>()\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;return a.test(this.user.email)},validatePassword(){const a=/^(?=.*[A-Za-z])(?=.*\d)[A-Za-z\d]{8,}$/;return a.test(this.user.password)},async register(){if(this.emailError=this.validateEmail()?"":"Invalid email format",this.passwordError=this.validatePassword()?"":"Password must be at least 8 characters long and include both letters and numbers",!this.emailError&&!this.passwordError)try{const a=await aa.Z.post("https://firetrack.cleverapps.io/api/users/register",this.user);this.$store.dispatch("loginUser",a.data),this.$emit("register-success")}catch(a){a.response&&409===a.response.status?this.registrationError="This email is already registered.":this.registrationError="An error occurred during registration."}}}};const Pa=(0,_.Z)(Ta,[["render",Ma],["__scopeId","data-v-b4b86c44"]]);var Ia=Pa,Ca={components:{LoginForm:oa,RegistrationForm:Ia},setup(){const a=(0,P.tv)(),e=()=>{a.push("/profile")},t=()=>{a.push("/map")};return{handleLoginSuccess:e,handleRegisterSuccess:t}}};const Ua=(0,_.Z)(Ca,[["render",F],["__scopeId","data-v-bd49cd8e"]]);var za=Ua;const Ha=a=>((0,i.dD)("data-v-957b4100"),a=a(),(0,i.Cn)(),a),Aa={class:"container mt-4"},Na=Ha((()=>(0,i._)("h1",null,"Interactive Map",-1))),Oa=Ha((()=>(0,i._)("div",{id:"map",class:"leaflet-map"},null,-1)));function Ra(a,e,t,o,r,n){const s=(0,i.up)("SensorHistory");return(0,i.wg)(),(0,i.iD)("div",Aa,[Na,Oa,r.showHistory?((0,i.wg)(),(0,i.j4)(s,{key:0,pointId:r.selectedPointId},null,8,["pointId"])):(0,i.kq)("",!0)])}var La=t(3153),Za=t.n(La),Ga=t.p+"img/marker.0fa9a017.svg";const Fa={class:"sensor-history mt-4"},qa={class:"table table-hover table-light"},Ba=(0,i._)("thead",null,[(0,i._)("tr",null,[(0,i._)("th",{class:"table-secondary"},"Timestamp"),(0,i._)("th",null,"Temperature"),(0,i._)("th",null,"Humidity"),(0,i._)("th",null,"Pressure"),(0,i._)("th",null,"Altitude"),(0,i._)("th",null,"Magnetometer"),(0,i._)("th",null,"Sound"),(0,i._)("th",null,"Colour")])],-1),$a={class:"table-secondary"};function ja(a,e,t,o,r,n){return(0,i.wg)(),(0,i.iD)("div",Fa,[(0,i._)("h3",null,"Sensor Data History for Point ID: "+(0,s.zw)(t.pointId),1),(0,i._)("table",qa,[Ba,(0,i._)("tbody",null,[((0,i.wg)(!0),(0,i.iD)(i.HY,null,(0,i.Ko)(n.displayedSensorData,(a=>((0,i.wg)(),(0,i.iD)("tr",{key:a.dataId},[(0,i._)("td",$a,(0,s.zw)(n.formatDate(a.timestamp)),1),(0,i._)("td",null,(0,s.zw)(a.temperature),1),(0,i._)("td",null,(0,s.zw)(a.humidity),1),(0,i._)("td",null,(0,s.zw)(a.pressure),1),(0,i._)("td",null,(0,s.zw)(a.altitude),1),(0,i._)("td",null,(0,s.zw)(a.magnetometer),1),(0,i._)("td",null,(0,s.zw)(a.sound),1),(0,i._)("td",null,(0,s.zw)(a.colour),1)])))),128))])]),n.displayedSensorData.length<r.sensorData.length?((0,i.wg)(),(0,i.iD)("button",{key:0,class:"btn btn-primary",onClick:e[0]||(e[0]=(...a)=>n.showMore&&n.showMore(...a))},"Show More")):(0,i.kq)("",!0)])}var xa={name:"SensorHistory",props:{pointId:Number},data(){return{sensorData:[],limit:5}},computed:{displayedSensorData(){return this.sensorData.slice(0,this.limit)}},watch:{pointId(a){this.fetchSensorData(a)}},methods:{async fetchSensorData(a){try{const e=await aa.Z.get(`http://firetrack.cleverapps.io/api/sensorData/${a}`);this.sensorData=e.data.reverse()}catch(e){console.error("Error fetching sensor data:",e)}},showMore(){this.limit+=5},formatDate(a){return new Date(a).toLocaleString()}},mounted(){this.fetchSensorData(this.pointId)}};const Wa=(0,_.Z)(xa,[["render",ja]]);var Va=Wa,Ja={name:"MapPage",components:{SensorHistory:Va},data(){return{map:null,trackingPoints:[],customMarkerIcon:Za().icon({iconUrl:Ga,iconSize:[32,32],iconAnchor:[16,32],popupAnchor:[0,-32]}),showHistory:!1,selectedPointId:null}},mounted(){this.initMap(),this.fetchTrackingPoints()},methods:{initMap(){this.map=Za().map("map",{scrollWheelZoom:!1}).setView([0,0],2),Za().tileLayer("https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png",{attribution:"© OpenStreetMap contributors"}).addTo(this.map),this.map.on("popupopen",(a=>{a.popup._container.addEventListener("show-history",this.showPointHistory)}))},async fetchTrackingPoints(){try{const a=await aa.Z.get("https://firetrack.cleverapps.io/api/trackingPoints");this.trackingPoints=a.data,this.addMarkers(),this.map.fitBounds(this.getMarkersBounds())}catch(a){console.error("Error fetching tracking points:",a)}},addMarkers(){this.trackingPoints.forEach((a=>{const e=Za().marker([a.latitude,a.longitude],{icon:this.customMarkerIcon}).addTo(this.map),t=`<div>\n                                <strong>Point ID:</strong> ${a.pointId}<br>\n                                <strong>Status:</strong> ${a.status}<br>\n                                <button class="btn btn-secondary btn-sm" onclick="this.dispatchEvent(new CustomEvent('show-history', { detail: ${a.pointId}, bubbles: true }))">Show History</button>\n                              </div>`;e.bindPopup(t)}))},showPointHistory(a){this.selectedPointId=a.detail,this.showHistory=!0,this.$nextTick((()=>{const a=this.$el.querySelector(".sensor-history");a&&a.scrollIntoView({behavior:"smooth"})}))},getMarkersBounds(){const a=Za().latLngBounds();return this.trackingPoints.forEach((e=>{a.extend([e.latitude,e.longitude])})),a}}};const Ya=(0,_.Z)(Ja,[["render",Ra],["__scopeId","data-v-957b4100"]]);var Ka=Ya;const Qa=a=>((0,i.dD)("data-v-52324483"),a=a(),(0,i.Cn)(),a),Xa={class:"profile-page container mt-4"},ae={class:"row"},ee={class:"col-md-6"},te=Qa((()=>(0,i._)("h2",null,"User Profile",-1))),oe={key:0,class:"profile-info"},ie={key:1,class:"no-history"},re=Qa((()=>(0,i._)("p",null,"User data is not available.",-1))),ne=[re],se={class:"col-md-6"},de=Qa((()=>(0,i._)("h2",null,"Scanning History",-1))),le={key:0},ce={class:"scanning-history-list"},ue={key:1,class:"no-history"},pe=Qa((()=>(0,i._)("p",null,"No scanning history available.",-1))),ve=[pe],ge={key:0,class:"modal",tabindex:"-1",role:"dialog"},me={class:"modal-dialog",role:"document"},he={class:"modal-content"},fe={class:"modal-header"},be=Qa((()=>(0,i._)("h5",{class:"modal-title"},"Confirm Deletion",-1))),ye=Qa((()=>(0,i._)("span",{"aria-hidden":"true"},"×",-1))),ke=[ye],we=Qa((()=>(0,i._)("div",{class:"modal-body"},[(0,i._)("p",null,"Are you sure you want to delete your account?")],-1))),_e={class:"modal-footer"};function De(a,e,t,o,r,n){return(0,i.wg)(),(0,i.iD)("div",Xa,[(0,i._)("div",ae,[(0,i._)("div",ee,[te,a.user?((0,i.wg)(),(0,i.iD)("div",oe,[((0,i.wg)(!0),(0,i.iD)(i.HY,null,(0,i.Ko)(a.userFields,(e=>((0,i.wg)(),(0,i.iD)("p",{key:e.key},[(0,i._)("strong",null,(0,s.zw)(e.label)+":",1),(0,i.Uk)(" "+(0,s.zw)(a.user[e.key]),1)])))),128)),(0,i._)("button",{onClick:e[0]||(e[0]=(...e)=>a.confirmDelete&&a.confirmDelete(...e)),class:"btn btn-danger"},"Delete Account")])):((0,i.wg)(),(0,i.iD)("div",ie,ne))]),(0,i._)("div",se,[de,a.displayedHistory.length>0?((0,i.wg)(),(0,i.iD)("div",le,[(0,i._)("ul",ce,[((0,i.wg)(!0),(0,i.iD)(i.HY,null,(0,i.Ko)(a.displayedHistory,(e=>((0,i.wg)(),(0,i.iD)("li",{key:e.historyId,class:"scanning-history-item"},[(0,i._)("p",null,[(0,i._)("strong",null,"Point "+(0,s.zw)(e.pointId)+":",1),(0,i.Uk)(" "+(0,s.zw)(a.formatDate(e.timestamp)),1)])])))),128))]),a.displayedHistory.length<a.scanningHistory.length?((0,i.wg)(),(0,i.iD)("button",{key:0,onClick:e[1]||(e[1]=(...e)=>a.showMore&&a.showMore(...e)),class:"btn btn-primary"},"Show More")):(0,i.kq)("",!0)])):((0,i.wg)(),(0,i.iD)("div",ue,ve))])]),a.showDeleteModal?((0,i.wg)(),(0,i.iD)("div",ge,[(0,i._)("div",me,[(0,i._)("div",he,[(0,i._)("div",fe,[be,(0,i._)("button",{type:"button",class:"close","data-dismiss":"modal","aria-label":"Close",onClick:e[2]||(e[2]=(...e)=>a.closeDeleteModal&&a.closeDeleteModal(...e))},ke)]),we,(0,i._)("div",_e,[(0,i._)("button",{type:"button",class:"btn btn-secondary","data-dismiss":"modal",onClick:e[3]||(e[3]=(...e)=>a.closeDeleteModal&&a.closeDeleteModal(...e))},"Cancel"),(0,i._)("button",{type:"button",class:"btn btn-danger",onClick:e[4]||(e[4]=(...e)=>a.deleteAccount&&a.deleteAccount(...e))},"Delete")])])])])):(0,i.kq)("",!0)])}var Ee=t(4870),Se=(0,i.aZ)({setup(){const a=(0,k.oR)(),e=(0,i.Fl)((()=>a.state.user)),t=(0,Ee.iH)([]),o=(0,Ee.iH)([]),r=(0,Ee.iH)(!1),n=5,s=[{key:"email",label:"Email"},{key:"firstName",label:"First Name"},{key:"lastName",label:"Last Name"},{key:"position",label:"Position"}],d=()=>{r.value=!0},l=()=>{r.value=!1},c=async()=>{try{await aa.Z.delete(`https://firetrack.cleverapps.io/api/users/${e.value.userId}`),a.dispatch("logoutUser"),Re.push("/")}catch(t){console.error("Error deleting account:",t)}},u=async()=>{try{const a=await aa.Z.get(`https://firetrack.cleverapps.io/api/scanningHistory/user/${e.value.userId}`);t.value=a.data.reverse(),o.value=t.value.slice(0,n)}catch(a){console.error("Error fetching scanning history:",a)}},p=a=>{const e=new Date(a);return e.toLocaleDateString()+" "+e.toLocaleTimeString()},v=()=>{const a=Math.min(t.value.length,o.value.length+n);o.value=t.value.slice(0,a)};return(0,i.bv)((()=>{u()})),{user:e,userFields:s,scanningHistory:t,displayedHistory:o,showDeleteModal:r,confirmDelete:d,closeDeleteModal:l,deleteAccount:c,formatDate:p,showMore:v}}});const Me=(0,_.Z)(Se,[["render",De],["__scopeId","data-v-52324483"]]);var Te=Me;const Pe={class:"documentation-layout"},Ie=(0,i.uE)('<div class="documentation-page container" data-v-67091eda><h1 class="my-4" data-v-67091eda>Documentation - FireTrack</h1><section id="about" class="my-4" data-v-67091eda><h2 data-v-67091eda>About</h2><p data-v-67091eda>FireTrack is an integrated wildfire management system designed to assist in the monitoring, early detection, and efficient response to wildfires. Developed by rabeezarre, the project encompasses both frontend and backend components and uses a variety of technologies including Spring Boot, Java 17, Gradle, Vue.js, SCSS, and Bootstrap.</p><h3 data-v-67091eda>Features</h3><ul data-v-67091eda><li data-v-67091eda>Real-time monitoring of forest conditions.</li><li data-v-67091eda>Tracking points inspections in the forest using mobile devices.</li><li data-v-67091eda>Timely emergency alerts for rapid response to wildfire incidents.</li></ul><h3 data-v-67091eda>Sub-Systems</h3><ul data-v-67091eda><li data-v-67091eda><strong data-v-67091eda>Web</strong>: Interactive map displaying tracking points information.</li><li data-v-67091eda><strong data-v-67091eda>Mobile</strong>: Tracking service for marking checked tracking points in real-time.</li><li data-v-67091eda><strong data-v-67091eda>Backend</strong>: Centralized database for web and mobile interfaces, built with Spring Boot using Java 17 and Gradle.</li><li data-v-67091eda><strong data-v-67091eda>Embedded Programming</strong>: Utilizes LoRaWAN protocol for scalable data sharing.</li></ul></section><section id="deployment" class="my-4" data-v-67091eda><h2 data-v-67091eda>Deployment</h2><p data-v-67091eda>FireTrack is deployed on CleverCloud. Access the live application here: <a href="https://firetrack.cleverapps.io/" target="_blank" data-v-67091eda>firetrack.cleverapps.io</a></p></section><section id="technology-stack" class="my-4" data-v-67091eda><h2 data-v-67091eda>Technology Stack</h2><ul data-v-67091eda><li data-v-67091eda>Backend: Java 17, Spring Boot, Gradle</li><li data-v-67091eda>Frontend: Vue.js, SCSS, Bootstrap</li><li data-v-67091eda>Database: H2 Database</li><li data-v-67091eda>API Documentation: Swagger</li></ul></section><section id="installation-and-setup" class="my-4" data-v-67091eda><h2 data-v-67091eda>Installation and Setup</h2><h3 data-v-67091eda>Backend</h3><ol data-v-67091eda><li data-v-67091eda>Clone the backend repository: <code data-v-67091eda>git clone https://github.com/rabeezarre/firetrack-backend.git</code></li><li data-v-67091eda>Navigate to the project directory: <code data-v-67091eda>cd firetrack-backend</code></li><li data-v-67091eda>Build the project using Gradle: <code data-v-67091eda>./gradlew build</code></li><li data-v-67091eda>The backend uses the build version of the frontend. To redeploy, add the build files to <code data-v-67091eda>src/main/resources/static</code>.</li></ol><h3 data-v-67091eda>Frontend</h3><ol data-v-67091eda><li data-v-67091eda>Clone the frontend repository: <code data-v-67091eda>git clone https://github.com/rabeezarre/firetrack-frontend.git</code></li><li data-v-67091eda>Navigate to the project directory: <code data-v-67091eda>cd firetrack-frontend</code></li><li data-v-67091eda>Install dependencies: <code data-v-67091eda>npm install</code></li><li data-v-67091eda>To compile and hot-reload for development: <code data-v-67091eda>npm run serve</code></li><li data-v-67091eda>To compile and minify for production: <code data-v-67091eda>npm run build</code></li><li data-v-67091eda>To lint and fix files: <code data-v-67091eda>npm run lint</code></li><li data-v-67091eda>After building for production, copy the build files to the backend&#39;s <code data-v-67091eda>src/main/resources/static</code> directory.</li></ol></section><section id="usage" class="my-4" data-v-67091eda><h2 data-v-67091eda>Usage</h2><p data-v-67091eda>FireTrack provides various RESTful API endpoints:</p><h3 data-v-67091eda>User Controller</h3><ul data-v-67091eda><li data-v-67091eda><strong data-v-67091eda>GET</strong> <code data-v-67091eda>/api/users/{userId}</code>: Retrieve user details by user ID.</li><li data-v-67091eda><strong data-v-67091eda>PUT</strong> <code data-v-67091eda>/api/users/{userId}</code>: Update user details.</li><li data-v-67091eda><strong data-v-67091eda>DELETE</strong> <code data-v-67091eda>/api/users/{userId}</code>: Delete a user.</li><li data-v-67091eda><strong data-v-67091eda>POST</strong> <code data-v-67091eda>/api/users/register</code>: Register a new user.</li><li data-v-67091eda><strong data-v-67091eda>POST</strong> <code data-v-67091eda>/api/users/login</code>: User login.</li></ul><h3 data-v-67091eda>Tracking Point Controller</h3><ul data-v-67091eda><li data-v-67091eda><strong data-v-67091eda>GET</strong> <code data-v-67091eda>/api/trackingPoints/{pointId}</code>: Get details of a specific tracking point.</li><li data-v-67091eda><strong data-v-67091eda>PUT</strong> <code data-v-67091eda>/api/trackingPoints/{pointId}</code>: Update a tracking point.</li><li data-v-67091eda><strong data-v-67091eda>DELETE</strong> <code data-v-67091eda>/api/trackingPoints/{pointId}</code>: Delete a tracking point.</li><li data-v-67091eda><strong data-v-67091eda>GET</strong> <code data-v-67091eda>/api/trackingPoints</code>: Retrieve all tracking points.</li><li data-v-67091eda><strong data-v-67091eda>POST</strong> <code data-v-67091eda>/api/trackingPoints</code>: Create a new tracking point.</li></ul><h3 data-v-67091eda>Alert Controller</h3><ul data-v-67091eda><li data-v-67091eda><strong data-v-67091eda>PUT</strong> <code data-v-67091eda>/api/alerts/{alertId}</code>: Update an alert.</li><li data-v-67091eda><strong data-v-67091eda>GET</strong> <code data-v-67091eda>/api/alerts</code>: Get all alerts.</li><li data-v-67091eda><strong data-v-67091eda>POST</strong> <code data-v-67091eda>/api/alerts</code>: Create a new alert.</li><li data-v-67091eda><strong data-v-67091eda>GET</strong> <code data-v-67091eda>/api/alerts/trackingPoint/{pointId}</code>: Get alerts for a specific tracking point.</li><li data-v-67091eda><strong data-v-67091eda>GET</strong> <code data-v-67091eda>/api/alerts/active</code>: Retrieve active alerts.</li></ul><h3 data-v-67091eda>Sensor Data Controller</h3><ul data-v-67091eda><li data-v-67091eda><strong data-v-67091eda>POST</strong> <code data-v-67091eda>/api/sensorData</code>: Submit new sensor data.</li><li data-v-67091eda><strong data-v-67091eda>GET</strong> <code data-v-67091eda>/api/sensorData/{pointId}</code>: Retrieve sensor data for a specific point.</li></ul><h3 data-v-67091eda>Scanning History Controller</h3><ul data-v-67091eda><li data-v-67091eda><strong data-v-67091eda>GET</strong> <code data-v-67091eda>/api/scanningHistory</code>: Get all scanning history records.</li><li data-v-67091eda><strong data-v-67091eda>POST</strong> <code data-v-67091eda>/api/scanningHistory</code>: Create a new scanning history record.</li><li data-v-67091eda><strong data-v-67091eda>GET</strong> <code data-v-67091eda>/api/scanningHistory/user/{userId}</code>: Get scanning history by user.</li><li data-v-67091eda><strong data-v-67091eda>GET</strong> <code data-v-67091eda>/api/scanningHistory/point/{pointId}</code>: Get scanning history for a specific point.</li></ul></section><section id="contributing" class="my-4" data-v-67091eda><h2 data-v-67091eda>Contributing</h2><p data-v-67091eda>Here are some ways you can contribute:</p><ol data-v-67091eda><li data-v-67091eda><strong data-v-67091eda>Reporting Bugs</strong></li><li data-v-67091eda><strong data-v-67091eda>Suggesting Enhancements</strong></li><li data-v-67091eda><strong data-v-67091eda>Submitting Pull Requests</strong></li><li data-v-67091eda><strong data-v-67091eda>Code Reviews</strong></li><li data-v-67091eda><strong data-v-67091eda>Documentation</strong></li></ol><h3 data-v-67091eda>Contribution Guidelines</h3><ul data-v-67091eda><li data-v-67091eda>Respect the code of conduct.</li><li data-v-67091eda>Before starting work on a significant change, please open an issue for discussion.</li><li data-v-67091eda>Keep the changes small and focused; larger changes are harder to review and merge.</li></ul></section><section id="license" class="my-4" data-v-67091eda><h2 data-v-67091eda>License</h2><p data-v-67091eda>This project is licensed under the MIT License.</p></section><section id="authors-and-acknowledgment" class="my-4" data-v-67091eda><h2 data-v-67091eda>Authors and Acknowledgment</h2><p data-v-67091eda>Author: rabeezarre <a href="https://github.com/rabeezarre" target="_blank" data-v-67091eda>GitHub user</a></p><p data-v-67091eda>For more details and updates, please refer to the <a href="https://github.com/rabeezarre/firetrack-backend" target="_blank" data-v-67091eda>backend repository</a> and the <a href="https://github.com/rabeezarre/firetrack-frontend" target="_blank" data-v-67091eda>frontend repository</a> on GitHub.</p></section></div>',1),Ce=[Ie];function Ue(a,e,t,o,r,n){return(0,i.wg)(),(0,i.iD)("div",Pe,Ce)}var ze={name:"DocumentationPage"};const He=(0,_.Z)(ze,[["render",Ue],["__scopeId","data-v-67091eda"]]);var Ae=He;const Ne=[{path:"/",name:"Home",component:O},{path:"/login",name:"Login",component:za},{path:"/map",name:"Map",component:Ka},{path:"/profile",name:"Profile",component:Te},{path:"/docs",name:"Docs",component:Ae}],Oe=(0,P.p7)({history:(0,P.PO)("/"),routes:Ne});var Re=Oe,Le=(0,k.MT)({state(){return{user:JSON.parse(localStorage.getItem("user"))||null}},mutations:{setUser(a,e){a.user=e,localStorage.setItem("user",JSON.stringify(e))},clearUser(a){a.user=null,localStorage.removeItem("user")}},actions:{loginUser({commit:a},e){a("setUser",e)},logoutUser({commit:a}){a("clearUser")}},getters:{isAuthenticated:a=>!!a.user,currentUser:a=>a.user}});const Ze=(0,o.ri)(T);Ze.use(Le),Ze.use(Re),Ze.mount("#app")}},e={};function t(o){var i=e[o];if(void 0!==i)return i.exports;var r=e[o]={exports:{}};return a[o].call(r.exports,r,r.exports,t),r.exports}t.m=a,function(){var a=[];t.O=function(e,o,i,r){if(!o){var n=1/0;for(c=0;c<a.length;c++){o=a[c][0],i=a[c][1],r=a[c][2];for(var s=!0,d=0;d<o.length;d++)(!1&r||n>=r)&&Object.keys(t.O).every((function(a){return t.O[a](o[d])}))?o.splice(d--,1):(s=!1,r<n&&(n=r));if(s){a.splice(c--,1);var l=i();void 0!==l&&(e=l)}}return e}r=r||0;for(var c=a.length;c>0&&a[c-1][2]>r;c--)a[c]=a[c-1];a[c]=[o,i,r]}}(),function(){t.n=function(a){var e=a&&a.__esModule?function(){return a["default"]}:function(){return a};return t.d(e,{a:e}),e}}(),function(){t.d=function(a,e){for(var o in e)t.o(e,o)&&!t.o(a,o)&&Object.defineProperty(a,o,{enumerable:!0,get:e[o]})}}(),function(){t.g=function(){if("object"===typeof globalThis)return globalThis;try{return this||new Function("return this")()}catch(a){if("object"===typeof window)return window}}()}(),function(){t.o=function(a,e){return Object.prototype.hasOwnProperty.call(a,e)}}(),function(){t.r=function(a){"undefined"!==typeof Symbol&&Symbol.toStringTag&&Object.defineProperty(a,Symbol.toStringTag,{value:"Module"}),Object.defineProperty(a,"__esModule",{value:!0})}}(),function(){t.p="/"}(),function(){var a={143:0};t.O.j=function(e){return 0===a[e]};var e=function(e,o){var i,r,n=o[0],s=o[1],d=o[2],l=0;if(n.some((function(e){return 0!==a[e]}))){for(i in s)t.o(s,i)&&(t.m[i]=s[i]);if(d)var c=d(t)}for(e&&e(o);l<n.length;l++)r=n[l],t.o(a,r)&&a[r]&&a[r][0](),a[r]=0;return t.O(c)},o=self["webpackChunkfiretrack_frontend"]=self["webpackChunkfiretrack_frontend"]||[];o.forEach(e.bind(null,0)),o.push=e.bind(null,o.push.bind(o))}();var o=t.O(void 0,[998],(function(){return t(6098)}));o=t.O(o)})();
//# sourceMappingURL=app.a8e796a6.js.map