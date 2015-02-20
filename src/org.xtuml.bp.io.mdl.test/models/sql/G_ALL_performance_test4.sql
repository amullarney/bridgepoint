-- BP 6.1D content: domain syschar: 3

INSERT INTO S_DOM
	VALUES (605060,
	'G_ALL_performance_test4',
	'Test4 creates and deletes 10000 active instances.',
	0,
	1);
INSERT INTO S_CDT
	VALUES (524289,
	0);
INSERT INTO S_DT
	VALUES (524289,
	605060,
	'void',
	'');
INSERT INTO S_CDT
	VALUES (524290,
	1);
INSERT INTO S_DT
	VALUES (524290,
	605060,
	'boolean',
	'');
INSERT INTO S_CDT
	VALUES (524291,
	2);
INSERT INTO S_DT
	VALUES (524291,
	605060,
	'integer',
	'');
INSERT INTO S_CDT
	VALUES (524292,
	3);
INSERT INTO S_DT
	VALUES (524292,
	605060,
	'real',
	'');
INSERT INTO S_CDT
	VALUES (524293,
	4);
INSERT INTO S_DT
	VALUES (524293,
	605060,
	'string',
	'');
INSERT INTO S_CDT
	VALUES (524294,
	5);
INSERT INTO S_DT
	VALUES (524294,
	605060,
	'unique_id',
	'');
INSERT INTO S_CDT
	VALUES (524295,
	6);
INSERT INTO S_DT
	VALUES (524295,
	605060,
	'state<State_Model>',
	'');
INSERT INTO S_CDT
	VALUES (524296,
	7);
INSERT INTO S_DT
	VALUES (524296,
	605060,
	'same_as<Base_Attribute>',
	'');
INSERT INTO S_CDT
	VALUES (524297,
	8);
INSERT INTO S_DT
	VALUES (524297,
	605060,
	'inst_ref<Object>',
	'');
INSERT INTO S_CDT
	VALUES (524298,
	9);
INSERT INTO S_DT
	VALUES (524298,
	605060,
	'inst_ref_set<Object>',
	'');
INSERT INTO S_CDT
	VALUES (524299,
	10);
INSERT INTO S_DT
	VALUES (524299,
	605060,
	'inst<Event>',
	'');
INSERT INTO S_CDT
	VALUES (524300,
	11);
INSERT INTO S_DT
	VALUES (524300,
	605060,
	'inst<Mapping>',
	'');
INSERT INTO S_CDT
	VALUES (524301,
	12);
INSERT INTO S_DT
	VALUES (524301,
	605060,
	'inst_ref<Mapping>',
	'');
INSERT INTO S_UDT
	VALUES (524302,
	524300,
	1);
INSERT INTO S_DT
	VALUES (524302,
	605060,
	'date',
	'');
INSERT INTO S_UDT
	VALUES (524303,
	524300,
	2);
INSERT INTO S_DT
	VALUES (524303,
	605060,
	'timestamp',
	'');
INSERT INTO S_UDT
	VALUES (524304,
	524301,
	3);
INSERT INTO S_DT
	VALUES (524304,
	605060,
	'inst_ref<Timer>',
	'');
INSERT INTO S_EE
	VALUES (524289,
	'Architecture',
	'',
	'ARCH',
	605060);
INSERT INTO S_BRG
	VALUES (524289,
	524289,
	'shutdown',
	'',
	0,
	524289,
	'',
	1);
INSERT INTO GD_MD
	VALUES (524289,
	1,
	605060,
	1,
	1,
	0,
	1,
	1,
	0,
	12,
	1600,
	4200,
	1.000000,
	0);
INSERT INTO GD_GE
	VALUES (524293,
	524289,
	1048578,
	11);
INSERT INTO GD_SHP
	VALUES (524293,
	1872,
	1312,
	2096,
	1472);
INSERT INTO GD_GE
	VALUES (524297,
	524289,
	524289,
	12);
INSERT INTO GD_SHP
	VALUES (524297,
	1872,
	1520,
	2096,
	1680);
INSERT INTO GD_MD
	VALUES (524290,
	2,
	605060,
	1,
	1,
	0,
	1,
	1,
	0,
	12,
	1600,
	4200,
	1.000000,
	0);
INSERT INTO GD_GE
	VALUES (524294,
	524290,
	1048578,
	11);
INSERT INTO GD_SHP
	VALUES (524294,
	1872,
	1312,
	2096,
	1472);
INSERT INTO GD_MD
	VALUES (524291,
	3,
	605060,
	1,
	1,
	0,
	1,
	1,
	0,
	12,
	1600,
	4200,
	1.000000,
	0);
INSERT INTO GD_GE
	VALUES (524295,
	524291,
	1048578,
	11);
INSERT INTO GD_SHP
	VALUES (524295,
	1872,
	1312,
	2096,
	1472);
INSERT INTO GD_MD
	VALUES (524292,
	4,
	605060,
	1,
	1,
	0,
	1,
	1,
	0,
	12,
	1600,
	4200,
	1.000000,
	0);
INSERT INTO GD_GE
	VALUES (524296,
	524292,
	1048578,
	11);
INSERT INTO GD_SHP
	VALUES (524296,
	1872,
	1312,
	2096,
	1472);
INSERT INTO S_SS
	VALUES (1048578,
	'Test4',
	'',
	'T4',
	1,
	605060,
	1048578);
INSERT INTO O_OBJ
	VALUES (1048577,
	'Initialization',
	1,
	'INIT',
	'',
	1048578);
INSERT INTO O_NBATTR
	VALUES (1048577,
	1048577);
INSERT INTO O_BATTR
	VALUES (1048577,
	1048577);
INSERT INTO O_ATTR
	VALUES (1048577,
	1048577,
	0,
	'id',
	'',
	'',
	'id',
	0,
	524294);
INSERT INTO O_NBATTR
	VALUES (1048578,
	1048577);
INSERT INTO O_BATTR
	VALUES (1048578,
	1048577);
INSERT INTO O_ATTR
	VALUES (1048578,
	1048577,
	1048577,
	'current_state',
	'',
	'',
	'current_state',
	0,
	524295);
INSERT INTO O_ID
	VALUES (0,
	1048577);
INSERT INTO O_OIDA
	VALUES (1048577,
	1048577,
	0);
INSERT INTO SM_ISM
	VALUES (1572867,
	1048577);
INSERT INTO SM_SM
	VALUES (1572867,
	'',
	3);
INSERT INTO SM_MOORE
	VALUES (1572867);
INSERT INTO SM_STATE
	VALUES (1572866,
	1572867,
	0,
	'Start',
	1,
	0);
INSERT INTO SM_MOAH
	VALUES (1572866,
	1572867,
	1572866);
INSERT INTO SM_AH
	VALUES (1572866,
	1572867);
INSERT INTO SM_ACT
	VALUES (1572866,
	1572867,
	1,
	'create object instance tc of TC;
generate TC1 to tc;',
	'');
INSERT INTO GD_MD
	VALUES (1572865,
	8,
	1572867,
	40,
	1,
	0,
	1,
	1,
	0,
	12,
	1600,
	4200,
	1.000000,
	0);
INSERT INTO GD_GE
	VALUES (1572867,
	1572865,
	1572866,
	41);
INSERT INTO GD_SHP
	VALUES (1572867,
	1712,
	1248,
	2000,
	1456);
INSERT INTO O_OBJ
	VALUES (1048578,
	'Test Class',
	2,
	'TC',
	'',
	1048578);
INSERT INTO O_NBATTR
	VALUES (1048579,
	1048578);
INSERT INTO O_BATTR
	VALUES (1048579,
	1048578);
INSERT INTO O_ATTR
	VALUES (1048579,
	1048578,
	0,
	'id',
	'',
	'',
	'id',
	0,
	524294);
INSERT INTO O_NBATTR
	VALUES (1048580,
	1048578);
INSERT INTO O_BATTR
	VALUES (1048580,
	1048578);
INSERT INTO O_ATTR
	VALUES (1048580,
	1048578,
	1048579,
	'current_state',
	'',
	'',
	'current_state',
	0,
	524295);
INSERT INTO O_ID
	VALUES (0,
	1048578);
INSERT INTO O_OIDA
	VALUES (1048579,
	1048578,
	0);
INSERT INTO SM_ISM
	VALUES (2097156,
	1048578);
INSERT INTO SM_SM
	VALUES (2097156,
	'',
	4);
INSERT INTO SM_MOORE
	VALUES (2097156);
INSERT INTO SM_SUPDT
	VALUES (2097154,
	2097156,
	0);
INSERT INTO SM_STATE
	VALUES (2097154,
	2097156,
	2097154,
	'State One',
	1,
	0);
INSERT INTO SM_LEVT
	VALUES (2097154,
	2097156,
	2097154);
INSERT INTO SM_SEVT
	VALUES (2097154,
	2097156,
	2097154);
INSERT INTO SM_EVT
	VALUES (2097154,
	2097156,
	2097154,
	1,
	'',
	0,
	'',
	'TC1',
	'');
INSERT INTO SM_SEME
	VALUES (2097154,
	2097154,
	2097156,
	2097154);
INSERT INTO SM_NSTXN
	VALUES (2097154,
	2097156,
	2097154,
	2097154,
	2097154);
INSERT INTO SM_TXN
	VALUES (2097154,
	2097156,
	2097154,
	2097154);
INSERT INTO SM_MOAH
	VALUES (2097154,
	2097156,
	2097154);
INSERT INTO SM_AH
	VALUES (2097154,
	2097156);
INSERT INTO SM_ACT
	VALUES (2097154,
	2097156,
	1,
	'OP::GetMasterStart( );

while( OP::IncreaseCount( ) <= 10000 )
  create object instance tc2 of TC2;
  delete object instance tc2;
end while;

OP::GetMasterFinish( );
OP::CalculateTime( );
ARCH::shutdown( );',
	'');
INSERT INTO GD_MD
	VALUES (2097153,
	8,
	2097156,
	40,
	1,
	0,
	1,
	1,
	0,
	12,
	1600,
	4200,
	1.000000,
	0);
INSERT INTO GD_GE
	VALUES (2097160,
	2097153,
	2097154,
	41);
INSERT INTO GD_SHP
	VALUES (2097160,
	1840,
	1392,
	2160,
	1616);
INSERT INTO GD_GE
	VALUES (2097161,
	2097153,
	2097154,
	42);
INSERT INTO GD_CON
	VALUES (2097161,
	2097160,
	2097160,
	0);
INSERT INTO GD_CTXT
	VALUES (2097161,
	0,
	0,
	0,
	0,
	0,
	0,
	1733,
	1328,
	1771,
	1350,
	1,
	-47,
	0,
	0,
	0,
	0,
	0,
	0);
INSERT INTO GD_LS
	VALUES (2097162,
	2097161,
	1840,
	1440,
	1776,
	1440,
	0);
INSERT INTO GD_LS
	VALUES (2097163,
	2097161,
	1776,
	1440,
	1776,
	1328,
	2097162);
INSERT INTO GD_LS
	VALUES (2097164,
	2097161,
	1776,
	1328,
	1888,
	1328,
	2097163);
INSERT INTO GD_LS
	VALUES (2097165,
	2097161,
	1888,
	1328,
	1888,
	1392,
	2097164);
INSERT INTO O_OBJ
	VALUES (1048580,
	'Op Class',
	4,
	'OP',
	'',
	1048578);
INSERT INTO O_TFR
	VALUES (1048577,
	1048580,
	'GetMasterStart',
	'',
	524289,
	0,
	'',
	1);
INSERT INTO O_TFR
	VALUES (1048578,
	1048580,
	'GetMasterFinish',
	'',
	524289,
	0,
	'',
	1);
INSERT INTO O_TFR
	VALUES (1048579,
	1048580,
	'CalculateTime',
	'',
	524289,
	0,
	'',
	1);
INSERT INTO O_TFR
	VALUES (1048581,
	1048580,
	'IncreaseCount',
	'',
	524291,
	0,
	'return -1;',
	1);
INSERT INTO O_NBATTR
	VALUES (1048583,
	1048580);
INSERT INTO O_BATTR
	VALUES (1048583,
	1048580);
INSERT INTO O_ATTR
	VALUES (1048583,
	1048580,
	0,
	'id',
	'',
	'',
	'id',
	0,
	524294);
INSERT INTO O_ID
	VALUES (0,
	1048580);
INSERT INTO O_OIDA
	VALUES (1048583,
	1048580,
	0);
INSERT INTO O_OBJ
	VALUES (1048581,
	'Test Class 2',
	3,
	'TC2',
	'',
	1048578);
INSERT INTO O_NBATTR
	VALUES (1048584,
	1048581);
INSERT INTO O_BATTR
	VALUES (1048584,
	1048581);
INSERT INTO O_ATTR
	VALUES (1048584,
	1048581,
	0,
	'id',
	'',
	'',
	'id',
	0,
	524294);
INSERT INTO O_NBATTR
	VALUES (1048585,
	1048581);
INSERT INTO O_BATTR
	VALUES (1048585,
	1048581);
INSERT INTO O_ATTR
	VALUES (1048585,
	1048581,
	1048584,
	'current_state',
	'',
	'',
	'current_state',
	0,
	524295);
INSERT INTO O_ID
	VALUES (0,
	1048581);
INSERT INTO O_OIDA
	VALUES (1048584,
	1048581,
	0);
INSERT INTO SM_ISM
	VALUES (3145734,
	1048581);
INSERT INTO SM_SM
	VALUES (3145734,
	'',
	6);
INSERT INTO SM_MOORE
	VALUES (3145734);
INSERT INTO GD_MD
	VALUES (3145729,
	8,
	3145734,
	40,
	1,
	0,
	1,
	1,
	0,
	12,
	1600,
	4200,
	1.000000,
	0);
INSERT INTO GD_MD
	VALUES (1048577,
	5,
	1048578,
	11,
	1,
	0,
	1,
	1,
	0,
	12,
	1600,
	4200,
	1.000000,
	0);
INSERT INTO GD_GE
	VALUES (1048580,
	1048577,
	1048577,
	21);
INSERT INTO GD_SHP
	VALUES (1048580,
	1696,
	1280,
	1920,
	1456);
INSERT INTO GD_GE
	VALUES (1048583,
	1048577,
	1048578,
	21);
INSERT INTO GD_SHP
	VALUES (1048583,
	2000,
	1280,
	2240,
	1456);
INSERT INTO GD_GE
	VALUES (1048589,
	1048577,
	1048580,
	21);
INSERT INTO GD_SHP
	VALUES (1048589,
	1696,
	1536,
	1920,
	1696);
INSERT INTO GD_GE
	VALUES (1048590,
	1048577,
	1048581,
	21);
INSERT INTO GD_SHP
	VALUES (1048590,
	2000,
	1536,
	2240,
	1696);
INSERT INTO GD_MD
	VALUES (1048578,
	6,
	1048578,
	11,
	1,
	0,
	1,
	1,
	0,
	12,
	1600,
	4200,
	1.000000,
	0);
INSERT INTO GD_GE
	VALUES (1048581,
	1048578,
	1048577,
	21);
INSERT INTO GD_SHP
	VALUES (1048581,
	1696,
	1280,
	1888,
	1344);
INSERT INTO GD_GE
	VALUES (1048584,
	1048578,
	1048578,
	21);
INSERT INTO GD_SHP
	VALUES (1048584,
	2000,
	1280,
	2192,
	1344);
INSERT INTO GD_GE
	VALUES (1048592,
	1048578,
	1048581,
	21);
INSERT INTO GD_SHP
	VALUES (1048592,
	2000,
	1536,
	2192,
	1600);
INSERT INTO GD_MD
	VALUES (1048579,
	7,
	1048578,
	11,
	1,
	0,
	1,
	1,
	0,
	12,
	1600,
	4200,
	1.000000,
	0);
INSERT INTO GD_GE
	VALUES (1048582,
	1048579,
	1048577,
	21);
INSERT INTO GD_SHP
	VALUES (1048582,
	1696,
	1280,
	1888,
	1344);
INSERT INTO GD_GE
	VALUES (1048585,
	1048579,
	1048578,
	21);
INSERT INTO GD_SHP
	VALUES (1048585,
	2000,
	1280,
	2192,
	1344);
INSERT INTO GD_GE
	VALUES (1048591,
	1048579,
	1048581,
	21);
INSERT INTO GD_SHP
	VALUES (1048591,
	2000,
	1536,
	2192,
	1600);