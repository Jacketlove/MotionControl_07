package com.tswe.common.constant;

public enum DllReturnInfo {
	
	motion_board_init			("motion_board_init",
			new String[]{"INSTANCE init failed\n", "INSTANCE already exists\n", "motion_board_init failed 1\n", "motion_board_init failed 2\n"},
			new String[]{"motion_board_init success\n"}),
	
	motion_board_init_serial	("motion_board_init_serial",
			new String[]{"INSTANCE init failed\n", "INSTANCE already exists\n", "motion_board_init failed 1\n", "motion_board_init failed 2\n"},
			new String[]{"motion_board_init success\n"}),
	
	motion_board_close			("motion_board_close",
			null,
			null),
	
	motion_get_card_type		("motion_get_card_type",
			new String[]{},
			new String[]{}),
	
	motion_set_pulse_outmode	("motion_set_pulse_outmode",
			new String[]{"motion_set_pulse_outmode failed 1"},
			new String[]{"motion_set_pulse_outmode success"}),
	
	motion_config_EMG_PIN		("motion_config_EMG_PIN",
			new String[]{"motion_config_EMG_PIN failed 1\n"},
			new String[]{"motion_config_EMG_PIN success\n"}),
	
	motion_config_SD_PIN		("motion_config_SD_PIN",
			new String[]{"motion_config_SD_PIN failed 1\n"},
			new String[]{"motion_config_SD_PIN success\n"}),
	
	motion_config_PCS_PIN		("motion_config_PCS_PIN",
			new String[]{"motion_config_PCS_PIN failed 1\n", "motion_config_PCS_PIN failed 2\n", "motion_config_PCS_PIN do nothing\n"},
			new String[]{})
			,
	
	motion_config_INP_PIN		("motion_config_INP_PIN",
			new String[]{"motion_config_INP_PIN failed 1\n"},
			new String[]{"motion_config_INP_PIN success\n"}),
	
	motion_config_ERC_PIN		("motion_config_ERC_PIN",
			new String[]{"motion_config_ERC_PIN failed 1\n", "motion_config_ERC_PIN failed 2\n", "motion_config_ERC_PIN do nothing\n"},
			new String[]{}),
	
	motion_config_ALM_PIN		("motion_config_ALM_PIN",
			new String[]{"motion_config_ALM_PIN failed 1\n", "motion_config_ALM_PIN do nothing\n"},
			new String[]{}),
	
	motion_config_EL_MODE		("motion_config_EL_MODE",
			new String[]{"motion_config_EL_MODE failed 1\n", "motion_config_EL_MODE failed 2\n", "motion_config_EL_MODE failed 3\n", "motion_config_EL_MODE failed 4\n", "motion_config_EL_MODE failed 5\n"},
			new String[]{"motion_config_EL_MODE success\n"}),
	
	motion_config_EZ_PIN		("motion_config_EZ_PIN",
			new String[]{"motion_config_EZ_PIN failed 1\n", "motion_config_EZ_PIN failed 2\n", "motion_config_EZ_PIN failed 3\n", "motion_config_EZ_PIN failed 4\n", "motion_config_EZ_PIN do nothing\n"},
			new String[]{}),
	
	motion_config_LTC_PIN		("motion_config_LTC_PIN",
			new String[]{"motion_config_LTC_PIN failed 3\n", "motion_config_LTC_PIN do nothing\n"},
			new String[]{}),
	
	motion_config_CMP_PIN		("motion_config_CMP_PIN",
			new String[]{"motion_config_CMP_PIN failed 1\n", },
			new String[]{"motion_config_CMP_PIN success\n"}),
	
	motion_read_CMP_PIN			("motion_read_CMP_PIN",
			new String[]{},
			new String[]{"motion_read_CMP_PIN success\n"}),
	
	motion_write_CMP_PIN		("motion_write_CMP_PIN",
			new String[]{"motion_write_CMP_PIN failed 1\n"},
			new String[]{"motion_write_CMP_PIN success\n"}),
	
	motion_config_comparator	("motion_config_comparator",
			new String[]{"motion_config_comparator failed 1\n"},
			new String[]{"motion_config_comparator success\n"}),
	
	motion_set_comparator_data	("motion_set_comparator_data",
			new String[]{"motion_set_comparator_data failed 1\n"},
			new String[]{"motion_set_comparator_data success\n"}),
	
	motion_set_HOME_pin_logic	("motion_set_HOME_pin_logic",
			new String[]{"motion_set_HOME_pin_logic failed 1\n"},
			new String[]{"motion_set_HOME_pin_logic success\n"}),
	
	motion_write_SEVON_PIN		("motion_write_SEVON_PIN",
			new String[]{"motion_write_SEVON_PIN failed 1\n"},
			new String[]{"motion_write_SEVON_PIN success\n"}),
	
	motion_read_SEVON_PIN		("motion_read_SEVON_PIN",
			new String[]{},
			new String[]{"motion_read_SEVON_PIN success\n"}),
	
	motion_read_RDY_PIN			("motion_read_RDY_PIN",
			new String[]{},
			new String[]{"motion_read_RDY_PIN success\n"}),
	
	motion_read_inbit			("motion_read_inbit",
			new String[]{},
			new String[]{"motion_read_inbit success\n"}),
	
	motion_write_outbit			("motion_write_outbit",
			new String[]{"motion_write_outbit failed 1\n"},
			new String[]{"motion_write_outbit success\n"}),
	
	motion_read_outbit			("motion_read_outbit",
			new String[]{},
			new String[]{"motion_read_outbit success\n"}),
	
	motion_read_inport			("motion_read_inport",
			new String[]{},
			new String[]{"motion_read_inport success\n"}),
	
	motion_read_outport			("motion_read_outport",
			new String[]{},
			new String[]{"motion_read_outport success\n"}),
	
	motion_write_outport		("motion_write_outport",
			new String[]{"motion_write_outport failed 2\n"},
			new String[]{"motion_write_outport success\n"}),
	
	motion_check_done			("motion_check_done",
			new String[]{},
			new String[]{"motion_check_done success\n"}),
	
	motion_axis_io_status		("motion_axis_io_status",
			new String[]{},
			new String[]{"motion_axis_io_status success\n"}),
	
	motion_get_rsts				("motion_get_rsts",
			new String[]{},
			new String[]{"motion_get_rsts success\n"}),
	
	motion_get_sig				("motion_get_sig",
			new String[]{},
			new String[]{"motion_get_axis_sig success\n"}),
	
	motion_get_status			("motion_get_status",
			new String[]{},
			new String[]{"motion_get_status success\n"}),
	
	motion_set_profile			("motion_set_profile",
			new String[]{"motion_set_profile failed 1\n"},
			new String[]{"motion_set_profile success\n"}),
	
	motion_set_st_profile		("motion_set_st_profile",
			new String[]{"motion_set_st_profile failed 1\n", "motion_set_st_profile failed 2\n", "motion_set_st_profile failed 3\n"},
			new String[]{"motion_set_st_profile success\n"}),
	
	motion_set_vector_profile	("motion_set_vector_profile",
			new String[]{"motion_set_vector_profile failed 1\n"},
			new String[]{"motion_set_vector_profile success\n"}),
	
	motion_set_st_vector_profile("motion_set_st_vector_profile",
			new String[]{"motion_set_st_vector_profile failed 1\n", "motion_set_st_vector_profile failed 2\n"},
			new String[]{"motion_set_st_vector_profile success\n"}),
	
	motion_change_speed			("motion_change_speed",
			new String[]{"motion_change_speed failed 1\n"},
			new String[]{"motion_change_speed success\n"}),
	
	motion_t_pmove				("motion_t_pmove",
			new String[]{"motion_t_pmove failed 1\n", "motion_t_pmove failed 2\n"},
			new String[]{"motion_t_pmove success\n"}),
	
	motion_s_pmove				("motion_s_pmove",
			new String[]{"motion_s_pmove failed 1\n", "motion_s_pmove failed 2\n"},
			new String[]{"motion_s_pmove success\n"}),
	
	motion_t_vmove				("motion_t_vmove",
			new String[]{"motion_t_vmove failed 1\n", "motion_t_vmove failed 2\n"},
			new String[]{"motion_t_vmove success\n"}),
	
	motion_s_vmove				("motion_s_vmove",
			new String[]{"motion_s_vmove failed 1\n", "motion_s_vmove failed 2\n"},
			new String[]{ "motion_s_vmove success\n"}),
	
	motion_t_line2				("motion_t_line2",
			new String[]{"motion_t_line2 failed 1\n", "motion_t_line2 failed 2\n", "motion_t_line2 failed 3\n", "motion_t_line2 failed 4\n"},
			new String[]{"motion_t_line2 success\n"}),
	
	motion_t_line3				("motion_t_line3",
			new String[]{"motion_t_line3 failed 1\n", "motion_t_line3 failed 2\n", "motion_t_line3 failed 3\n", "motion_t_line3 failed 4\n"},
			new String[]{"motion_t_line3 success\n"}),
	
	motion_t_line4				("motion_t_line4",
			new String[]{"motion_t_line4 failed 1\n", "motion_t_line4 failed 2\n"},
			new String[]{ "motion_t_line4 success\n"}),
	
	motion_line					("motion_line",
			new String[]{"motion_line failed 1\n", "motion_line failed 2\n", "motion_line failed 3\n", "motion_line failed 4\n"},
			new String[]{"motion_line success\n"}),
	
	motion_arc_move				("motion_arc_move",
			new String[]{"motion_arc_move failed 1\n", "motion_arc_move failed 2\n", "motion_arc_move failed 3\n", "motion_arc_move failed 4\n"},
			new String[]{"motion_arc_move success\n"}),
	
	motion_rel_arc_move			("motion_rel_arc_move",
			new String[]{"motion_rel_arc_move failed 1\n",  "motion_rel_arc_move failed 2\n", "motion_rel_arc_move failed 3\n", "motion_rel_arc_move failed 4\n"},
			new String[]{"motion_rel_arc_move success\n"}),
	
	motion_decel_stop			("motion_decel_stop",
			new String[]{"motion_decel_stop failed 1\n"},
			new String[]{"motion_decel_stop success\n"}),
	
	motion_imd_stop				("motion_imd_stop",
			new String[]{"motion_imd_stop failed 1\n"},
			new String[]{"motion_imd_stop success\n"}),
	
	motion_emg_stop				("motion_emg_stop",
			new String[]{"motion_emg_stop failed 1\n"},
			new String[]{"motion_emg_stop finish\n"}),
	
	motion_read_current_speed	("motion_read_current_speed",
			new String[]{},
			new String[]{"motion_read_current_speed success\n"}),
	
	motion_get_position			("motion_get_position",
			new String[]{},
			new String[]{"motion_get_position success\n"}),
	
	motion_set_position			("motion_set_position",
			new String[]{"motion_set_position failed 1\n"},
			new String[]{"motion_set_position success\n"}),
	
	motion_config_home_mode		("motion_config_home_mode",
			new String[]{"motion_config_home_mode failed 1\n", "motion_config_home_mode failed 2\n", "motion_config_home_mode failed 3\n"},
			new String[]{"motion_config_home_mode success\n"}),
	
	motion_home_move			("motion_home_move",
			new String[]{"motion_home_move failed 1\n", "motion_home_move failed 2\n", "motion_home_move failed 3\n"},
			new String[]{"motion_home_move success\n"}),
	
	motion_counter_config		("motion_counter_config",
			new String[]{"motion_counter_config failed 1\n", "motion_counter_config failed 2\n"},
			new String[]{"motion_counter_config success\n"}),
	
	motion_get_encoder			("motion_get_encoder",
			new String[]{},
			new String[]{"motion_get_encoder success\n"}),
	
	motion_set_encoder			("motion_set_encoder",
			new String[]{ "motion_set_encoder failed 1\n"},
			new String[]{"motion_set_encoder success\n"}),
	
	motion_config_latch_mode	("motion_config_latch_mode",
			new String[]{"motion_config_latch_mode failed 1\n", "motion_config_latch_mode do nothing\n", "motion_config_latch_mode failed 3\n"},
			new String[]{"motion_config_latch_mode success\n"}),
	
	motion_triger_chunnel		("motion_triger_chunnel",
			new String[]{"motion_triger_chunnel failed 1\n", "motion_triger_chunnel do nothing\n", "motion_triger_chunnel failed 2\n"},
			new String[]{"motion_triger_chunnel success\n"}),
	
	motion_get_latch_value		("motion_get_latch_value",
			new String[]{"motion_get_latch_value failed 1\n", "motion_get_latch_value do nothing\n"},
			new String[]{}),
	
	motion_set_t_move_all		("motion_set_t_move_all",
			new String[]{"motion_set_t_move_all failed 1\n", "motion_set_t_move_all failed 2\n", "motion_set_t_move_all failed 3\n", "motion_set_t_move_all failed 4\n", "motion_set_t_move_all failed 5\n"},
			new String[]{"motion_set_t_move_all success\n"}),
	
	motion_start_move_all		("motion_start_move_all",
			new String[]{"motion_start_move_all failed 1\n"},
			new String[]{"motion_start_move_all success\n"}),
	
	motion_simultaneous_stop	("motion_simultaneous_stop",
			new String[]{"motion_simultaneous_stop failed 1\n"},
			new String[]{"motion_simultaneous_stop success\n"}),
	
	motion_set_sync_option		("motion_set_sync_option",
			new String[]{"motion_set_sync_option failed 1\n"},
			new String[]{"motion_set_sync_option success\n"}),
	
	motion_set_sync_stop_mode	("motion_set_sync_stop_mode",
			new String[]{"motion_set_sync_stop_mode failed 1\n"},
			new String[]{"motion_set_sync_stop_mode success\n"}),
	
	motion_simultaneous_disable	("motion_simultaneous_disable",
			new String[]{"motion_simultaneous_disable failed 1\n"},
			new String[]{"motion_simultaneous_disable success\n"});
	
	String methodName;
	String[] failedInfo;
	String[] successInfo;
	private DllReturnInfo(String methodName, String[] failedInfo, String[] successInfo) {
		this.methodName = methodName;
		this.failedInfo = failedInfo;
		this.successInfo = successInfo;
	}
	public String getMethodName() {
		return methodName;
	}
	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}
	public String[] getFailedInfo() {
		return failedInfo;
	}
	public void setFailedInfo(String[] failedInfo) {
		this.failedInfo = failedInfo;
	}
	public String[] getSuccessInfo() {
		return successInfo;
	}
	public void setSuccessInfo(String[] successInfo) {
		this.successInfo = successInfo;
	}
	
}
