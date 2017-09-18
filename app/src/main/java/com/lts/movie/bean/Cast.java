package com.lts.movie.bean;

import java.util.List;

/**
 * Created by lts on 2017/9/16.
 * Fuction:
 * Update:
 */

public class Cast {

    /**
     * id : 278
     * cast : [{"cast_id":3,"character":"Andy Dufresne","credit_id":"52fe4231c3a36847f800b131","gender":2,"id":504,"name":"Tim Robbins","order":0,"profile_path":"/7pirFsBQe93TSfzu404Hgcj1YWj.jpg"},{"cast_id":4,"character":"Ellis Boyd 'Red' Redding","credit_id":"52fe4231c3a36847f800b135","gender":2,"id":192,"name":"Morgan Freeman","order":1,"profile_path":"/oGJQhOpT8S1M56tvSsbEBePV5O1.jpg"},{"cast_id":5,"character":"Warden Samuel Norton","credit_id":"52fe4231c3a36847f800b139","gender":2,"id":4029,"name":"Bob Gunton","order":2,"profile_path":"/b3NfI0IzPYI40eIEtO9O0XQiR8j.jpg"},{"cast_id":8,"character":"Captain Byron T. Hadley","credit_id":"52fe4231c3a36847f800b141","gender":2,"id":6574,"name":"Clancy Brown","order":3,"profile_path":"/xBVifBW0riMSbedEQ27hObjPqVw.jpg"},{"cast_id":10,"character":"Bogs Diamond","credit_id":"52fe4231c3a36847f800b149","gender":2,"id":6576,"name":"Mark Rolston","order":4,"profile_path":"/bsh3cqDNwVvux4NdaY1Bj4S7mNS.jpg"},{"cast_id":11,"character":"Brooks Hatlen","credit_id":"52fe4231c3a36847f800b14d","gender":2,"id":6577,"name":"James Whitmore","order":5,"profile_path":"/r1xOgXFjqhn2fonn78rlXKPZGFw.jpg"},{"cast_id":9,"character":"Tommy","credit_id":"52fe4231c3a36847f800b145","gender":2,"id":6575,"name":"Gil Bellows","order":6,"profile_path":"/msGHWcelT17HW70FDIXdjGmPmMK.jpg"},{"cast_id":7,"character":"Heywood","credit_id":"52fe4231c3a36847f800b13d","gender":2,"id":6573,"name":"William Sadler","order":7,"profile_path":"/nnr5u5lTL9cScrMSKV5MwslgSnn.jpg"},{"cast_id":28,"character":"1946 D.A.","credit_id":"540dc040c3a36879b200546e","gender":0,"id":12645,"name":"Jeffrey DeMunn","order":8,"profile_path":"/n47DHl1RFfSEKUvL0MKGKwrL71S.jpg"},{"cast_id":29,"character":"Skeet","credit_id":"542eb4a5c3a3680439000009","gender":2,"id":92119,"name":"Larry Brandenburg","order":9,"profile_path":"/3TGsmGFwJps4dmVncOZIO3p6ToO.jpg"},{"cast_id":30,"character":"Jigger","credit_id":"542eb4b1c3a3680436000003","gender":0,"id":168323,"name":"Neil Giuntoli","order":10,"profile_path":"/rfZpmKHhsgQkCL1TjOfBGptcQj4.jpg"},{"cast_id":31,"character":"Floyd","credit_id":"542eb4bd0e0a2625a6000004","gender":0,"id":6580,"name":"Brian Libby","order":11,"profile_path":"/lvY7hpUtU12BUD8mwQqFymnsxFI.jpg"},{"cast_id":32,"character":"Snooze","credit_id":"542eb4c90e0a2625a6000007","gender":2,"id":2555,"name":"David Proval","order":12,"profile_path":"/ujBzP61tYlwqWpB3oOxknl1XuEg.jpg"},{"cast_id":33,"character":"Ernie","credit_id":"542eb4d50e0a2625a3000005","gender":2,"id":5063,"name":"Joseph Ragno","order":13,"profile_path":"/46Mpe1MjqlyOjcYUTHQOLUxpo5j.jpg"},{"cast_id":34,"character":"Guard Mert","credit_id":"542eb4ecc3a368043d00000f","gender":2,"id":8693,"name":"Jude Ciccolella","order":14,"profile_path":"/6nuAG4DVlCc0h2rfrbpJhdmKudx.jpg"},{"cast_id":37,"character":"Guard Trout","credit_id":"55bf9dd3c3a3685f9c00029e","gender":2,"id":32393,"name":"Paul McCrane","order":15,"profile_path":"/3scBDtcQnu9LPQTORMLzyXDW3a1.jpg"},{"cast_id":38,"character":"Andy Dufresne's Wife","credit_id":"55bf9df6c3a3686540007655","gender":0,"id":6578,"name":"Renee Blaine","order":16,"profile_path":"/7R8OHmYLHEQ5j9gY2aQctrEN4Vo.jpg"},{"cast_id":74,"character":"Glenn Quentin","credit_id":"5741b355c3a36841090001be","gender":0,"id":1624179,"name":"Scott Mann","order":17,"profile_path":"/gXPgBwCqH7fUXfLJwUpTEbUSJ8T.jpg"},{"cast_id":40,"character":"1946 Judge","credit_id":"55bf9e569251413e4f007378","gender":0,"id":163979,"name":"John Horton","order":18,"profile_path":"/1EV5T9uFVfSxu96HNJV5hIGEb1N.jpg"},{"cast_id":41,"character":"1947 Parole Hearings Man","credit_id":"55bf9e7bc3a3686534007ffc","gender":0,"id":194459,"name":"Gordon Greene","order":19,"profile_path":null},{"cast_id":42,"character":"Fresh Fish Con","credit_id":"55bf9e999251413e58006e32","gender":2,"id":52603,"name":"Alfonso Freeman","order":20,"profile_path":"/xzIwjgSZA4ObAGxq69zlLJewKW9.jpg"},{"cast_id":43,"character":"Hungry Fish Con","credit_id":"55bf9eb8c3a3686526006a86","gender":0,"id":122596,"name":"V.J. Foster","order":21,"profile_path":"/dWGoTFHsAfjXC6yF6ODi61cH5Jt.jpg"},{"cast_id":44,"character":"Fat Ass","credit_id":"55bf9ef19251413e510072f6","gender":0,"id":1216752,"name":"Frank Medrano","order":22,"profile_path":"/rMd8vzLUCOGnp3d1mDF1GJJnjvy.jpg"},{"cast_id":45,"character":"Tyrell","credit_id":"55bf9f099251413bed00580a","gender":0,"id":139992,"name":"Mack Miles","order":23,"profile_path":"/noms8utyzIqpYrmudlPEKakRuWo.jpg"},{"cast_id":46,"character":"Rooster","credit_id":"55bf9f6ec3a3686534008019","gender":2,"id":32656,"name":"Gary Lee Davis","order":24,"profile_path":null},{"cast_id":48,"character":"Guard Youngblood","credit_id":"55bf9fd4c3a3685f9c0002d5","gender":2,"id":2141,"name":"Ned Bellamy","order":25,"profile_path":"/aPAsdVFewZK3ldhvrL1ea2VUkUK.jpg"},{"cast_id":49,"character":"Guard Dekins","credit_id":"55bfa0269251413e4f0073a9","gender":2,"id":6579,"name":"Brian Delate","order":26,"profile_path":"/i8Ses7u7vQZ6DNVmU0e3hzNbgXb.jpg"},{"cast_id":50,"character":"Guard Wiley","credit_id":"55bfa05892514107f1000284","gender":2,"id":79025,"name":"Don McManus","order":27,"profile_path":"/8JOjJkZBQmhVb6n8yHw70LIgC7i.jpg"},{"cast_id":51,"character":"1954 Landlady","credit_id":"55bfa08ac3a3683921005320","gender":0,"id":1422439,"name":"Dorothy Silver","order":28,"profile_path":"/gHUBpJpngl2XpIvBg5iIkf2Gb8Z.jpg"},{"cast_id":52,"character":"Head Bull Haig","credit_id":"55bfa0d39251413e51007313","gender":2,"id":91420,"name":"Dion Anderson","order":29,"profile_path":"/pFzPUgU08znvgB6B2S7wSo96teX.jpg"},{"cast_id":53,"character":"1954 Food-Way Manager","credit_id":"55bfa1239251413e550075d6","gender":2,"id":123302,"name":"Robert Haley","order":30,"profile_path":null},{"cast_id":54,"character":"Elmo Blatch","credit_id":"55f1bb1a9251416707002302","gender":2,"id":105649,"name":"Bill Bolender","order":31,"profile_path":null},{"cast_id":55,"character":"Bullhorn Tower Guard","credit_id":"55f1bb429251414530000ce1","gender":0,"id":1123794,"name":"John R. Woodward","order":32,"profile_path":null},{"cast_id":56,"character":"Bugle Editor","credit_id":"55f1bba0c3a36822ef0020c2","gender":0,"id":27690,"name":"Rohn Thomas","order":33,"profile_path":null},{"cast_id":57,"character":"1967 Parole Hearings Man","credit_id":"55f1bbcc9251414530000cf2","gender":2,"id":48587,"name":"Brian Brophy","order":34,"profile_path":"/5gBklXXdZqJrvdfrwpOoZYSQXlJ.jpg"},{"cast_id":93,"character":"Ned Grimes","credit_id":"57d2e6389251410d15001177","gender":0,"id":1537819,"name":"Ken Magee","order":35,"profile_path":null},{"cast_id":58,"character":"Con (uncredited)","credit_id":"55f1bc07c3a36822ef0020d3","gender":2,"id":25659,"name":"James Babson","order":36,"profile_path":"/PsYYzL0CcFhCGyq2rpQq8uHF8n.jpg"},{"cast_id":59,"character":"Police Officer (uncredited)","credit_id":"55f1bc30c3a36822ef0020d9","gender":0,"id":1185588,"name":"Fred Culbertson","order":37,"profile_path":null},{"cast_id":60,"character":"Inmate (uncredited)","credit_id":"55f1bc88c3a36822fe0023a9","gender":0,"id":92647,"name":"Alonzo F. Jones","order":38,"profile_path":null},{"cast_id":61,"character":"Inmate II (uncredited)","credit_id":"55f1bd7a9251416711002388","gender":2,"id":1337623,"name":"Actor Sergio Kato","order":39,"profile_path":"/5omR2Cu7ojfFCCL6CZDtlHhV9ni.jpg"},{"cast_id":70,"character":"Frank (uncredited)","credit_id":"56d48f3cc3a36870ac0015d9","gender":2,"id":1584544,"name":"Philip Ettington","order":40,"profile_path":"/64FGQbLQIlMtbBhulqQgpDSMmIR.jpg"},{"cast_id":94,"character":"Pete","credit_id":"57dd161e9251414a1500528a","gender":2,"id":389763,"name":"Neil Summers","order":41,"profile_path":"/k2pExO7H0zZu6HrOnOlP1XzhIPl.jpg"}]
     * crew : [{"credit_id":"52fe4231c3a36847f800b127","department":"Directing","gender":2,"id":4027,"job":"Director","name":"Frank Darabont","profile_path":"/9KVvZtDyy8DXacw2TTsjC9VLxQi.jpg"},{"credit_id":"52fe4231c3a36847f800b12d","department":"Production","gender":0,"id":4028,"job":"Producer","name":"Niki Marvin","profile_path":null},{"credit_id":"52fe4231c3a36847f800b153","department":"Sound","gender":2,"id":153,"job":"Original Music Composer","name":"Thomas Newman","profile_path":"/nZSsNIrjbkqqxFYwsD3zcHskxdP.jpg"},{"credit_id":"52fe4231c3a36847f800b159","department":"Camera","gender":2,"id":151,"job":"Director of Photography","name":"Roger Deakins","profile_path":"/osGe7eLKNIErFLn1RHJDeYTYOmb.jpg"},{"credit_id":"52fe4231c3a36847f800b15f","department":"Editing","gender":2,"id":6581,"job":"Editor","name":"Richard Francis-Bruce","profile_path":null},{"credit_id":"52fe4231c3a36847f800b165","department":"Production","gender":0,"id":6583,"job":"Casting","name":"Julie Lichter","profile_path":null},{"credit_id":"52fe4231c3a36847f800b16b","department":"Art","gender":2,"id":6584,"job":"Production Design","name":"Terence Marsh","profile_path":null},{"credit_id":"52fe4231c3a36847f800b171","department":"Production","gender":1,"id":3965,"job":"Casting","name":"Deborah Aquila","profile_path":"/7OBiqW30sXcW4f2xMds53L4JBN5.jpg"},{"credit_id":"52fe4231c3a36847f800b17d","department":"Writing","gender":2,"id":4027,"job":"Writer","name":"Frank Darabont","profile_path":"/9KVvZtDyy8DXacw2TTsjC9VLxQi.jpg"},{"credit_id":"575cfd879251412b0c001d2a","department":"Writing","gender":2,"id":3027,"job":"Novel","name":"Stephen King","profile_path":"/z8cHPoqTslxRR7oWQ5wsh0fNLt2.jpg"},{"credit_id":"557378f7c3a3686ef90023b9","department":"Production","gender":1,"id":46347,"job":"Executive Producer","name":"Liz Glotzer","profile_path":"/guI0c9r0K5F37ytaT7IqSr8J0la.jpg"},{"credit_id":"55737903c3a36838d3004e64","department":"Production","gender":2,"id":4054,"job":"Executive Producer","name":"David V. Lester","profile_path":null},{"credit_id":"5657a69fc3a3683083000231","department":"Art","gender":2,"id":6801,"job":"Set Decoration","name":"Michael Seirton","profile_path":null},{"credit_id":"565897f09251416dd30033bd","department":"Sound","gender":0,"id":1541839,"job":"ADR & Dubbing","name":"Paul J. Zydel","profile_path":null},{"credit_id":"5672ef2992514157b70008b0","department":"Crew","gender":2,"id":1550237,"job":"Sound Recordist","name":"John Soukup","profile_path":null},{"credit_id":"5675ec3cc3a36816800039d7","department":"Crew","gender":2,"id":1551320,"job":"Sound Recordist","name":"Jack Keller","profile_path":null},{"credit_id":"5681e2239251412e52010596","department":"Lighting","gender":0,"id":1464521,"job":"Rigging Gaffer","name":"Richie Ford","profile_path":null},{"credit_id":"5681e315c3a3686075010d8b","department":"Crew","gender":0,"id":1555028,"job":"Cinematography","name":"Bobby Mancuso","profile_path":null},{"credit_id":"568f066e9251416b52003ed1","department":"Editing","gender":0,"id":1552549,"job":"Color Timer","name":"David Orr","profile_path":null},{"credit_id":"56a7b851c3a36828b800191b","department":"Sound","gender":0,"id":230436,"job":"ADR & Dubbing","name":"Barbara Harris","profile_path":null},{"credit_id":"56ddbfe2c3a3685d67000070","department":"Costume & Make-Up","gender":2,"id":957990,"job":"Makeup Artist","name":"Monty Westmore","profile_path":null},{"credit_id":"570156b1925141607a0002c1","department":"Editing","gender":0,"id":1558250,"job":"Assistant Editor","name":"Robert C. Lusted","profile_path":null},{"credit_id":"5745cd1692514127cb00062a","department":"Art","gender":2,"id":2026,"job":"Art Direction","name":"Peter Landsdown Smith","profile_path":null},{"credit_id":"5745cd80c3a3681b9c000684","department":"Costume & Make-Up","gender":1,"id":5710,"job":"Costume Design","name":"Elizabeth McBride","profile_path":null},{"credit_id":"5745cdd89251413e5e002ef7","department":"Costume & Make-Up","gender":0,"id":1470182,"job":"Hairstylist","name":"Roy Bryson","profile_path":null},{"credit_id":"5745ce219251416594000d77","department":"Production","gender":0,"id":1432028,"job":"Production Supervisor","name":"Kokayi Ampah","profile_path":null},{"credit_id":"5745ce56c3a3682a2e0005ef","department":"Production","gender":1,"id":61381,"job":"Production Supervisor","name":"Sue Bea Montgomery","profile_path":null},{"credit_id":"5745ce97c3a3681b3a000618","department":"Directing","gender":0,"id":1123794,"job":"Assistant Director","name":"John R. Woodward","profile_path":null},{"credit_id":"5745cf07c3a3681b3a00062a","department":"Directing","gender":0,"id":106117,"job":"Assistant Director","name":"Thomas Schellenberg","profile_path":null},{"credit_id":"5745cf6ec3a3682a730005f8","department":"Directing","gender":2,"id":77295,"job":"Assistant Director","name":"Jesse V. Johnson","profile_path":"/zQQNkrzkuoqMFeL9tsZIQrtDcp3.jpg"},{"credit_id":"5745cfe092514127cb00067f","department":"Crew","gender":0,"id":1311828,"job":"Special Effects","name":"Bob Williams","profile_path":null},{"credit_id":"5745d12492514153c1002735","department":"Visual Effects","gender":0,"id":1400821,"job":"Visual Effects Producer","name":"Melissa Taylor","profile_path":null},{"credit_id":"5745d1abc3a368698e00196a","department":"Crew","gender":2,"id":127314,"job":"Stunt Coordinator","name":"Jerry Gatlin","profile_path":null},{"credit_id":"5745d2ed92514129a0002e65","department":"Camera","gender":0,"id":40120,"job":"Grip","name":"Brian 'Buzz' Buzzelli","profile_path":null},{"credit_id":"5745d4be925141323200065b","department":"Lighting","gender":0,"id":1401997,"job":"Gaffer","name":"Bill O'Leary","profile_path":null},{"credit_id":"574b1d2892514140010016b3","department":"Crew","gender":2,"id":1401262,"job":"Stunts","name":"Dick Hancock","profile_path":null},{"credit_id":"575221589251414c5a0004a2","department":"Costume & Make-Up","gender":0,"id":1319490,"job":"Makeup Artist","name":"Kevin Haney","profile_path":null},{"credit_id":"575221c29251414c4c000446","department":"Costume & Make-Up","gender":2,"id":1317,"job":"Key Hair Stylist","name":"Philip Ivey","profile_path":null},{"credit_id":"57c71a9d9251417366005714","department":"Sound","gender":0,"id":1325119,"job":"Additional Soundtrack","name":"Tommy Morgan","profile_path":null},{"credit_id":"5824b35d9251416d180008ee","department":"Crew","gender":0,"id":1573081,"job":"Cinematography","name":"Andy Harris","profile_path":null},{"credit_id":"58bf3964c3a368515e000efd","department":"Art","gender":0,"id":1771822,"job":"Art Department Assistant","name":"Rhonda Yeater","profile_path":null},{"credit_id":"58bf39a9c3a368513b00104a","department":"Art","gender":0,"id":1771823,"job":"Assistant Art Director","name":"Jack Evans","profile_path":null},{"credit_id":"58bf39b8c3a3685146000f7d","department":"Art","gender":0,"id":1392236,"job":"Construction Coordinator","name":"Sebastian Milito","profile_path":null},{"credit_id":"58bf39ccc3a3685146000f91","department":"Art","gender":0,"id":1771824,"job":"Construction Foreman","name":"Dixwell Stillman","profile_path":null},{"credit_id":"58bf39ddc3a368516c001018","department":"Art","gender":0,"id":1771825,"job":"Painter","name":"Blair Gibeau","profile_path":null},{"credit_id":"58bf3a38c3a368518200107b","department":"Art","gender":0,"id":1405708,"job":"Set Designer","name":"Antoinette J. Gordon","profile_path":null},{"credit_id":"58bf3a7dc3a3685146001001","department":"Art","gender":0,"id":1771827,"job":"Standby Painter","name":"Todd Hatfield","profile_path":null},{"credit_id":"58bf3ad2c3a3685146001054","department":"Camera","gender":0,"id":1771830,"job":"First Assistant Camera","name":"Robin Brown","profile_path":null},{"credit_id":"58bf3ae4925141367b001229","department":"Camera","gender":0,"id":1771831,"job":"Key Grip","name":"Don Cerrone","profile_path":null},{"credit_id":"58bf3af6c3a368513b00112c","department":"Camera","gender":2,"id":1278542,"job":"Aerial Camera","name":"Robert 'Bobby Z' Zajonc","profile_path":"/yeK916uQBf9galMQBytSfLkeMR7.jpg"},{"credit_id":"58bf3b14925141367b001243","department":"Camera","gender":0,"id":1771832,"job":"Steadicam Operator","name":"Gerrit Dangremond","profile_path":null},{"credit_id":"58bf3b21925141367b001251","department":"Camera","gender":0,"id":1712066,"job":"Still Photographer","name":"Michael P. Weinstein","profile_path":null},{"credit_id":"58bf3b3fc3a3685182001149","department":"Costume & Make-Up","gender":0,"id":1771834,"job":"Seamstress","name":"Carol Buckler","profile_path":null},{"credit_id":"58bf3b57c3a3685152001106","department":"Costume & Make-Up","gender":0,"id":1771836,"job":"Set Dressing Artist","name":"Jack Hering","profile_path":null},{"credit_id":"58bf3b8cc3a368512100122d","department":"Crew","gender":0,"id":1771838,"job":"Carpenter","name":"Paul Wells","profile_path":null},{"credit_id":"58bf3b9a925141367b0012b7","department":"Crew","gender":0,"id":1771839,"job":"Craft Service","name":"Brian Boggs","profile_path":null},{"credit_id":"58bf3badc3a368517700115e","department":"Crew","gender":0,"id":1771840,"job":"Driver","name":"Robert Conrad","profile_path":null},{"credit_id":"58bf3bbcc3a368516c00114e","department":"Crew","gender":0,"id":1771841,"job":"Executive Music Producer","name":"Dan Goldwasser","profile_path":null},{"credit_id":"58bf3bcac3a3685177001174","department":"Crew","gender":0,"id":1771842,"job":"Loader","name":"Hope A. Nielsen","profile_path":null},{"credit_id":"58bf3bdac3a3685146001109","department":"Crew","gender":0,"id":1771843,"job":"Picture Car Coordinator","name":"Mario Simon","profile_path":null},{"credit_id":"58bf3becc3a368515200118b","department":"Production","gender":0,"id":1771844,"job":"Production Office Coordinator","name":"Beth Hickman","profile_path":null},{"credit_id":"58bf3bf992514136770012d9","department":"Crew","gender":0,"id":1611791,"job":"Projection","name":"Alan Jacques","profile_path":null},{"credit_id":"58bf3c0ec3a36851820011ef","department":"Crew","gender":0,"id":1621232,"job":"Propmaker","name":"Earl F. Betts","profile_path":null},{"credit_id":"58bf3c21c3a368513b00121c","department":"Art","gender":0,"id":1771847,"job":"Property Master","name":"Tom Shaw Jr.","profile_path":null},{"credit_id":"58bf3c33925141367b001355","department":"Crew","gender":0,"id":1771850,"job":"Set Production Assistant","name":"Jesse E. Johnson","profile_path":null},{"credit_id":"58bf3c5b92514136490013a5","department":"Crew","gender":0,"id":237921,"job":"Stunts","name":"Daniel W. Barringer","profile_path":null},{"credit_id":"58bf3c75925141367b00138b","department":"Crew","gender":0,"id":1185588,"job":"Transportation Captain","name":"Fred Culbertson","profile_path":null},{"credit_id":"58bf3c8c92514136490013df","department":"Crew","gender":0,"id":1392250,"job":"Transportation Coordinator","name":"David Marder","profile_path":null},{"credit_id":"58bf3ca1c3a36851460011b3","department":"Production","gender":2,"id":4054,"job":"Unit Production Manager","name":"David V. Lester","profile_path":null},{"credit_id":"58bf3cb9c3a368513b00129f","department":"Crew","gender":0,"id":91941,"job":"Unit Publicist","name":"Ernie Malik","profile_path":null},{"credit_id":"58bf3cd8c3a368515e0011ab","department":"Crew","gender":0,"id":1771855,"job":"Video Assist Operator","name":"Van Scarboro","profile_path":null},{"credit_id":"58bf3ceac3a368516c001245","department":"Directing","gender":0,"id":74823,"job":"Script Supervisor","name":"Sioux Richards","profile_path":null},{"credit_id":"58bf3d1dc3a368515200129d","department":"Editing","gender":0,"id":1771858,"job":"First Assistant Editor","name":"Patricia A. Galvin","profile_path":null},{"credit_id":"58bf3d38c3a368515e001217","department":"Lighting","gender":0,"id":108147,"job":"Best Boy Electric","name":"Jeremy Knaster","profile_path":null},{"credit_id":"58bf3d56c3a36851520012d7","department":"Lighting","gender":0,"id":1771859,"job":"Electrician","name":"Kurt Dale Hartman","profile_path":null},{"credit_id":"58bf3d74c3a36851520012f6","department":"Lighting","gender":0,"id":1771861,"job":"Rigging Grip","name":"Rex Buckingham","profile_path":null},{"credit_id":"58bf3d87c3a368513b001340","department":"Production","gender":0,"id":1432028,"job":"Location Manager","name":"Kokayi Ampah","profile_path":null},{"credit_id":"58bf3d9cc3a3685152001316","department":"Production","gender":0,"id":1771862,"job":"Production Accountant","name":"Ramona Sánchez-Waggoner","profile_path":null},{"credit_id":"58bf3db7925141368b001495","department":"Sound","gender":0,"id":1424155,"job":"ADR Supervisor","name":"Petra Bach","profile_path":null},{"credit_id":"58bf3dc692514136700012ce","department":"Sound","gender":0,"id":1378229,"job":"Boom Operator","name":"Marvin E. Lewis","profile_path":null},{"credit_id":"58bf3ddec3a368515e001289","department":"Sound","gender":0,"id":1771864,"job":"Assistant Sound Editor","name":"Lori Martino","profile_path":null},{"credit_id":"58bf3def9251413649001528","department":"Sound","gender":0,"id":1376818,"job":"Foley","name":"Kevin Bartnof","profile_path":null},{"credit_id":"58bf3dfc925141368b0014ca","department":"Sound","gender":2,"id":7538,"job":"Music Editor","name":"Bill Bernstein","profile_path":null},{"credit_id":"58bf3e169251413649001545","department":"Sound","gender":0,"id":1549209,"job":"Orchestrator","name":"Thomas Pasatieri","profile_path":null},{"credit_id":"58bf3e2fc3a368515e0012ba","department":"Sound","gender":2,"id":1546115,"job":"Production Sound Mixer","name":"Willie D. Burton","profile_path":null},{"credit_id":"58bf3e45c3a368516c00135a","department":"Sound","gender":2,"id":1413169,"job":"Scoring Mixer","name":"Dennis S. Sands","profile_path":null},{"credit_id":"58bf3e60c3a368515e0012d5","department":"Sound","gender":0,"id":1439690,"job":"Sound Editor","name":"Bruce Bell","profile_path":null},{"credit_id":"58bf3e7fc3a3685121001476","department":"Sound","gender":2,"id":1455403,"job":"Supervising Sound Editor","name":"John Stacy","profile_path":"/l2Prs0tI05DbW3YnNKhiPItNqVv.jpg"},{"credit_id":"58bf3ea99251413670001377","department":"Writing","gender":0,"id":1771866,"job":"Storyboard","name":"Pete von Sholly","profile_path":null},{"credit_id":"58bf3ebe92514136770014e4","department":"Crew","gender":0,"id":1771867,"job":"Thanks","name":"Dennis Baker","profile_path":null}]
     */

    private int id;
    private List<CastBean> cast;
    private List<CrewBean> crew;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<CastBean> getCast() {
        return cast;
    }

    public void setCast(List<CastBean> cast) {
        this.cast = cast;
    }

    public List<CrewBean> getCrew() {
        return crew;
    }

    public void setCrew(List<CrewBean> crew) {
        this.crew = crew;
    }

    public static class CastBean {
        /**
         * cast_id : 3
         * character : Andy Dufresne
         * credit_id : 52fe4231c3a36847f800b131
         * gender : 2
         * id : 504
         * name : Tim Robbins
         * order : 0
         * profile_path : /7pirFsBQe93TSfzu404Hgcj1YWj.jpg
         */

        private int cast_id;
        private String character;
        private String credit_id;
        private int gender;
        private int id;
        private String name;
        private int order;
        private String profile_path;

        public int getCast_id() {
            return cast_id;
        }

        public void setCast_id(int cast_id) {
            this.cast_id = cast_id;
        }

        public String getCharacter() {
            return character;
        }

        public void setCharacter(String character) {
            this.character = character;
        }

        public String getCredit_id() {
            return credit_id;
        }

        public void setCredit_id(String credit_id) {
            this.credit_id = credit_id;
        }

        public int getGender() {
            return gender;
        }

        public void setGender(int gender) {
            this.gender = gender;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getOrder() {
            return order;
        }

        public void setOrder(int order) {
            this.order = order;
        }

        public String getProfile_path() {
            return profile_path;
        }

        public void setProfile_path(String profile_path) {
            this.profile_path = profile_path;
        }
    }

    public static class CrewBean {
        /**
         * credit_id : 52fe4231c3a36847f800b127
         * department : Directing
         * gender : 2
         * id : 4027
         * job : Director
         * name : Frank Darabont
         * profile_path : /9KVvZtDyy8DXacw2TTsjC9VLxQi.jpg
         */

        private String credit_id;
        private String department;
        private int gender;
        private int id;
        private String job;
        private String name;
        private String profile_path;

        public String getCredit_id() {
            return credit_id;
        }

        public void setCredit_id(String credit_id) {
            this.credit_id = credit_id;
        }

        public String getDepartment() {
            return department;
        }

        public void setDepartment(String department) {
            this.department = department;
        }

        public int getGender() {
            return gender;
        }

        public void setGender(int gender) {
            this.gender = gender;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getJob() {
            return job;
        }

        public void setJob(String job) {
            this.job = job;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getProfile_path() {
            return profile_path;
        }

        public void setProfile_path(String profile_path) {
            this.profile_path = profile_path;
        }
    }
}
